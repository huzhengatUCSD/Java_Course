package ch21.nonblock;
import java.net.*;
import java.nio.channels.*;
import java.nio.*;
import java.io.*;
import java.nio.charset.*;
import java.util.*;
/*
  示例：PingClient类不断接收用户输入的域名（字符串），然后
  与该主机的80端口建立连接，并打印建立连接所花费的时间（毫秒）

  如果无法连接到指定的主机，就打印相关错误信息。

  输入bye，则结束程序

*/

class Target {  //设计一个Target类，用类中的信息来表示一项任务
  InetSocketAddress address;  //该连接任务对应的地址
  SocketChannel channel;  //该连接任务绑定的非阻塞的SocketChannel对象
  Exception failure;      //错误类型对象
  long connectStart;  //开始连接时的时间
  long connectFinish = 0;  //连接成功时的时间
  boolean shown = false;  //该任务是否已经打印

  Target(String host) {
      try {
          address = new InetSocketAddress(InetAddress.getByName(host),80); //只是形成任务，并没开始执行任务！
      } catch (IOException x) {
          failure = x;  //从这可看出： failure 属性的作用了
      }
  }

  void show() {  //打印任务执行的结果   
      String result;
      if (connectFinish != 0)
          result = Long.toString(connectFinish - connectStart) + "ms";
      else if (failure != null)
          result = failure.toString();
      else
          result = "Timed out";
      System.out.println(address + " : " + result);
      shown = true;
  }
}

public class PingClient{
  private Selector selector;
  //targets是 链表式集合对象，存放用户新提交的任务
  private LinkedList targets=new LinkedList();
  // finishedTargets 是 链表对象，存放已经完成的需要打印的任务
  private LinkedList finishedTargets=new LinkedList();

  public PingClient()throws IOException{
    selector=Selector.open();
    Connector connector=new Connector(); /*定义的内部类 （定义见代码后续部分）Connector 负责从
	                                       任务队列中 targets 取出Target对象（即任务），然后向
										   Selector注册连接就绪事件(这些操作由PingClient的
										   registerTargets()实现)。Connector线程还负责向Selector
										   查询已经连接就绪的事件，然后把相应的Target对象加入到
										   已完成任务finishedTragets队列中。										  
										 */
    Printer printer=new Printer();       //负责从finishedTragets队列取出Targets对象，通过调用它的
	                                     //show()方法来答应执行任务的结果。
    connector.start();
    printer.start();
    receiveTarget();           //主线程，从控制台接收输入的主机名，然后提交Target队列
  }

  public static void main(String args[])throws IOException{
    new PingClient();
  }
  public void addTarget(Target target) {
    //向targets队列中加入一个任务. 主线程会调用它。
	//模式 producer-consumer pattern
     SocketChannel socketChannel = null;
      try {
          socketChannel = SocketChannel.open();
          socketChannel.configureBlocking(false);
          socketChannel.connect(target.address);//工作模式非阻塞，成功与否都立即返回

          target.channel = socketChannel;
          target.connectStart = System.currentTimeMillis();  //此时设置为开始时间。
		  //System.out.println(target.address+" start time: " +target.connectStart);

           synchronized (targets) {  //targets有多个使用其的线程存在，需要设置同步
             selector.wakeup(); //如果在向队列加入一个Target对象之前还没有任何SocketChannel
		                       //向Selector对象注册连接就绪事件，Connector线程执行selector.select()
							   //方法时，会永远阻塞下去。
			 
			 targets.add(target);
           }
            
       } catch (Exception x) {
          if (socketChannel != null) {
              try {
                  socketChannel.close();
              } catch (IOException xx) { }
          }
          target.failure = x;
          addFinishedTarget(target);
      }
  }

  public void addFinishedTarget(Target target) {
      //向finishedTargets队列中加入一个任务，主线程和Connector线程会调用该方法
      synchronized (finishedTargets) {
      finishedTargets.notify();  //多线程通信的知识，通知唤醒在该对象上阻塞的线程，但这些线程还没有被上锁。
	                             //区分对象的等待池、与锁池
      finishedTargets.add(target);
     }
  }

  public void printFinishedTargets() {
    //打印finisedTargets队列中的任务。Printer线程会调用该方法
     try {
        for (;;) {
            Target target = null;
            synchronized (finishedTargets) {
                while (finishedTargets.size() == 0)
                    finishedTargets.wait();
                target = (Target)finishedTargets.removeFirst();
            }
            target.show();
        }
    } catch (InterruptedException x) {
        return;
    }
  }

  public void registerTargets(){
    //取出targets队列中的任务，向Selector注册连接就绪事件。Connector线程会调用
    synchronized (targets) {
      while (targets.size() > 0) {
        Target target = (Target)targets.removeFirst();

        try {
          target.channel.register(selector, SelectionKey.OP_CONNECT, target);
        } catch (IOException x) {
              try{target.channel.close();}catch(IOException e){e.printStackTrace();}
              target.failure = x;
              addFinishedTarget(target);
        }
      }
    }
  }

  public void processSelectedKeys() throws IOException {
    //处理连接就绪事件，Connector会调用，以统计连接所耗时间，做“善后处理"
    for (Iterator it = selector.selectedKeys().iterator(); it.hasNext();) {
      SelectionKey selectionKey = (SelectionKey)it.next();
      it.remove();

      Target target = (Target)selectionKey.attachment();
      SocketChannel socketChannel = (SocketChannel)selectionKey.channel();

      try {
          if (socketChannel.finishConnect()) {
              selectionKey.cancel();
              target.connectFinish = System.currentTimeMillis();
			  //System.out.println(target.address+" finishtime: " +target.connectFinish);
              socketChannel.close();
              addFinishedTarget(target);
          }
      } catch (IOException x) {
          socketChannel.close();
          target.failure = x;
          addFinishedTarget(target);
      }
    }
  }

  public void receiveTarget(){
    //接收用户输入的地址，向targets队列中加入任务，主线程会调用该方法
    try{
      BufferedReader localReader=new BufferedReader(new InputStreamReader(System.in));
      String msg=null;
      while((msg=localReader.readLine())!=null){
        if(!msg.equals("bye")){
          Target target=new Target(msg);
          addTarget(target);
        }else{
          shutdown=true;
          selector.wakeup();
          break;
        }
      }
    }catch(IOException e){
       e.printStackTrace();
    }
  }

  boolean shutdown=false;  //用于控制Connnector线程

  public class Printer extends Thread{
    public Printer(){
        setDaemon(true);  //设置为后台线程
    }
    public void run(){
        printFinishedTargets();
    }
  }

  public class Connector extends Thread{
    public void run(){
		//在主线程未设置关闭标示前，一直使用循环来完成任务操作——核心部分！
        while (!shutdown) {
            try {
				//先从Targets队列中取出已经尝试连接的任务，并注册该任务对应的连接就绪事件
                registerTargets();
                if (selector.select() > 0) {
			    //紧接着，如果有连接就绪事件发生，然后进行相应的处理
                    processSelectedKeys();   //
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
       }
       try{
           selector.close();
       }catch(IOException e){e.printStackTrace();}
    }
  }
}
 
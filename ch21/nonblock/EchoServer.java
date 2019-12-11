package ch21.nonblock;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.net.*;
import java.util.*;

public class EchoServer{
  private Selector selector = null;
  private ServerSocketChannel serverSocketChannel = null;
  private int port = 8000;
  private Charset charset=Charset.forName("GBK");

  public EchoServer()throws IOException{
     //服务器启动（初始化）的一系列举措
    selector = Selector.open();
    serverSocketChannel= ServerSocketChannel.open(); //静态方法生成一个ServerSocketChannel对象
    serverSocketChannel.socket().setReuseAddress(true); //可重用端口
    serverSocketChannel.configureBlocking(false);
    serverSocketChannel.socket().bind(new InetSocketAddress(port));
    System.out.println("服务器启动");
  }

  public void service() throws IOException{
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT );
	
    while (selector.select() > 0 ){
      Set readyKeys = selector.selectedKeys();
	  
      Iterator it = readyKeys.iterator();
      while (it.hasNext()){
         SelectionKey key=null;
         try{
            key = (SelectionKey) it.next();
            
            it.remove();


            if (key.isAcceptable()) {
		      //System.out.println("key.readyOps()返回值为： "+key.readyOps()); //测试一下key.readyOps()返回的值，以理解后面几个分支判断的原理
              ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
              //System.out.println(ssc.isBlocking());//(false);
              //System.out.println("又来一个连接，转入处理客户连接的accept()");
              SocketChannel socketChannel = (SocketChannel) ssc.accept(); //调用accept()返回的SocketChannel对象默认情况下处于阻塞模式
              System.out.println("接收到客户连接，来自:" +
                                 socketChannel.socket().getInetAddress() +
                                 ":" + socketChannel.socket().getPort());
              socketChannel.configureBlocking(false); // 如果希望它执行非阻塞的IO操作，需要此句命令调用。
              ByteBuffer buffer = ByteBuffer.allocate(1024);
              SelectionKey key1=socketChannel.register(selector,
                                     SelectionKey.OP_READ, buffer);
            }
            if (key.isReadable()) {
                //System.out.println("key.readyOps()返回值为： "+key.readyOps()); //测试一下key.readyOps()返回的值，以理解后面几个分支判断的原理
				if((key.interestOps() & SelectionKey.OP_WRITE) == 0) {
                      key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
                }
				receive(key);
            }
            if (key.isWritable()) {
			 	key.interestOps(SelectionKey.OP_READ); 
             //   System.out.println(key.interestOps());
				send(key);
            }
        }catch(IOException e){
           e.printStackTrace();
           try{
               if(key!=null){
                   key.cancel();
                   key.channel().close();
               }
           }catch(Exception ex){e.printStackTrace();}
        }
      }//#while
    }//#while
  }

  public void send(SelectionKey key)throws IOException{
    //获得与SelectionKey关联的ByteBuffer    
	ByteBuffer buffer=(ByteBuffer)key.attachment();
	//以及SocketChannel
    SocketChannel socketChannel=(SocketChannel)key.channel();
    buffer.flip();  //把极限设为位置，把位置设为0，也就是为发送准备好初始指针和数目
    String data=decode(buffer); //按照GBK编码，把buffer中的字节转换为字符串
    if(data.indexOf("\r\n")==-1)return; //如果还没有读到一行数据，就返回
    String outputData=data.substring(0,data.indexOf("\n")+1); 
    System.out.print(outputData);
    ByteBuffer outputBuffer=encode("echo:"+outputData);
    while(outputBuffer.hasRemaining())
      socketChannel.write(outputBuffer); //输出不一定一次性输出，因此有了这个循环
   
    ByteBuffer temp=encode(outputData);//此三句是为了调整buffer的属性以便删除已处理的数据
    buffer.position(temp.limit());
    buffer.compact();

    if(outputData.equals("bye\r\n")){
      key.cancel();
      socketChannel.close();
      System.out.println("关闭与客户的连接");
    }
  }

  public void receive(SelectionKey key)throws IOException{
    ByteBuffer buffer=(ByteBuffer)key.attachment(); //先获取与这个key相关联的ByteBuffer

    SocketChannel socketChannel=(SocketChannel)key.channel();//关联的SocketChannel
    ByteBuffer readBuff= ByteBuffer.allocate(32);
    socketChannel.read(readBuff);
    readBuff.flip();

    buffer.limit(buffer.capacity());
    buffer.put(readBuff);
  }

  public String decode(ByteBuffer buffer){  //解码
    CharBuffer charBuffer= charset.decode(buffer);
    return charBuffer.toString();
  }
  public ByteBuffer encode(String str){  //编码
    return charset.encode(str);
  }

  public static void main(String args[])throws Exception{
    //EchoServer server = new EchoServer();
    //server.service();

	new EchoServer().service();
  }
}


 
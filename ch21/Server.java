package ch21;

import java.io.*;
import java.net.*;
public class Server {
  private int port=8081;
  private ServerSocket serverSocket;
  
  public Server() throws IOException {
    serverSocket = new ServerSocket(port);
    System.out.println("服务器启动");
  }

  public String echo(String msg) {
    return "echo:" + msg;
  }

  private PrintWriter getWriter(Socket socket)throws IOException{
    OutputStream socketOut = socket.getOutputStream();
    return new PrintWriter(socketOut,true);
  }
  private BufferedReader getReader(Socket socket)throws IOException{
    InputStream socketIn = socket.getInputStream();
    return new BufferedReader(new InputStreamReader(socketIn));
  }

  public void service() {
    while (true) {
      Socket socket=null;
      try {
        socket = serverSocket.accept();  //等待客户连接
        System.out.println("New connection accepted " 
                        +socket.getInetAddress().getHostAddress() + ":" +socket.getPort());
        //System.out.println("New connection accepted " 
        //        +socket.getInetAddress().getHostName() + ":" +socket.getPort());
        BufferedReader br =getReader(socket);
        PrintWriter pw = getWriter(socket);

        String msg = null;
        while ((msg = br.readLine()) != null) {
          System.out.println(msg); 
          pw.println(echo(msg));
          if (msg.equals("bye")) //如果客户发送的消息为“bye”，就结束通信
            break;
        }
      }catch (IOException e) {
         e.printStackTrace();
      }finally {
         try{
           if(socket!=null)socket.close();  //断开连接
         }catch (IOException e) {e.printStackTrace();}
      }
    }
  }

  public static void main(String args[])throws IOException {
    new Server().service();
  }
}




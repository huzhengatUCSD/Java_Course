package ch21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class MultiClientServer {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8081)) {
            //循环接受客户端请求
            while(true) {
                Socket socket = server.accept();
                handle(socket);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 处理客户请求
     * @param socket
     */
    private static void handle(Socket socket) {
        //开启一个线程,lambda表达式
        new Thread(() -> {
            try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                while(true) {
                    String message =  in.readLine();
                    System.out.println(message);
                    writer.println("Server received: " + message);
                    if("bye".equals(message)) {
                        break;
                    }
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

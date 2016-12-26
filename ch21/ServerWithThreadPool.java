package ch21;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ServerWithThreadPool {
	private int port = 8081;
	private ServerSocket serverSocket;
	private ExecutorService executorService; // 线程池
	private final int POOL_SIZE = 4; // 单个CPU时线程池中工作线程的数目

	private boolean isShutdown = false; // 服务器是否已经关闭

	public ServerWithThreadPool() throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(60000); // 设定等待客户连接的超过时间为60秒

		// 创建线程池
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
				.availableProcessors() * POOL_SIZE);

		// controlThread.start(); //启动负责关闭服务器的线程
		System.out.println("服务器启动");
	}

	public void service() {
		while (!isShutdown) {
			Socket socket = null;
			try {
				socket = serverSocket.accept(); // 可能会抛出SocketTimeoutException和SocketException
				socket.setSoTimeout(60000); // 把等待客户发送数据的超时时间设为60秒
				executorService.execute(new Handler(socket)); // 可能会抛出RejectedExecutionException
			} catch (SocketTimeoutException e) {
				// 不必处理等待客户连接时出现的超时异常
			} catch (RejectedExecutionException e) {
				// 如果是与客户的连接被拒绝，则关闭对应的socket
				try {
					if (socket != null)
						socket.close();
				} catch (IOException x) {
				}
				return;
			} catch (SocketException e) {
				// 如果是由于在执行serverSocket.accept()方法时，
				// ServerSocket被ShutdownThread线程关闭而导致的异常，就退出service()方法
				if (e.getMessage().indexOf("socket closed") != -1)
					return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) throws IOException {
		new ServerWithThreadPool().service();
	}
}

class Handler implements Runnable {
	private Socket socket;

	public Handler(Socket socket) {
		this.socket = socket;
	}

	private PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream socketOut = socket.getOutputStream();
		return new PrintWriter(socketOut, true);
	}

	private BufferedReader getReader(Socket socket) throws IOException {
		InputStream socketIn = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}

	public String echo(String msg) {
		return "Server echo:" + msg;
	}

	public void run() {
		try {
			System.out.println("New connnection accepted"
					+ socket.getInetAddress() + ";" + socket.getPort());
			BufferedReader br = getReader(socket);
			PrintWriter pw = getWriter(socket);

			String msg = null;
			while ((msg = br.readLine()) != null) {
				System.out.println(socket.getInetAddress() + ":"
						+ socket.getPort() + " : " + msg);
				pw.println(echo(msg));
				if (msg.equals("bye"))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

};

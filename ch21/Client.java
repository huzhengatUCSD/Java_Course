package ch21;


import java.io.*;
import java.net.*;
import java.util.*;


public class Client
{
	private String host="localhost";
	private int port=8081;
	private Socket socket;
	public Client() throws IOException{
		socket = new Socket(host,port);
	}
	public static void main(String[] args)throws IOException 
	{
		new Client().talk();//
	}

	private PrintWriter getWriter(Socket socket)throws IOException{
		OutputStream socketOut = socket.getOutputStream();  //
		return new PrintWriter(socketOut,true);
	}
	private BufferedReader getReader(Socket socket)throws IOException{
		InputStream socketIn = socket.getInputStream(); //
		return new BufferedReader(new InputStreamReader(socketIn));
	}

	public void talk()throws IOException{
		try
		{
			BufferedReader br = getReader(socket);
			PrintWriter pw=getWriter(socket);
			BufferedReader localReader=new BufferedReader(new InputStreamReader(System.in));
			String msg=null;

			while ((msg=localReader.readLine())!=null)
			{
				pw.println(msg);
				System.out.println(br.readLine());
				if (msg.equals("bye"))
				{
					break;
				}
		    }
          //  pw.println(msg);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}finally{
			try
			{
				socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}

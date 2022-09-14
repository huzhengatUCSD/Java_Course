package ch17;

import java.io.*;

public class User implements Serializable {
	private String name;
	private transient String password;
	private static int i ;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public void setI(int input) {
		i=input;
	}
	
	public int getI() {
		return i;
	}
	public String toString() {
		return name + " " + password;
	}

	/**
	 * 加密数组，将buff数组中的每个字节的每一位取反 例如13的二进制为00001101，取反后为11110010
	 */
	private byte[] change(byte[] buff) {
		for (int i = 0; i < buff.length; i++) {
			int b = 0;
			for (int j = 0; j < 8; j++) {
				int bit = (buff[i] >> j & 1) == 0 ? 1 : 0;
				b += (1 << j) * bit;
			}
			buff[i] = (byte) b;
		}
		return buff;
	}

	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject(); // 先按默认方式序列化
		stream.writeObject(change(password.getBytes())); //把密码这个非Serializable的部分加密后，在存成2进制流
	}

	private void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {
		stream.defaultReadObject(); // 先按默认方式反序列化
		byte[] buff = (byte[]) stream.readObject();//从二进制流中恢复非默认序列化的加了密的密码部分
		password = new String(change(buff)); //解密
	}

	public static void main(String[] args) throws Exception {
		
		  User user = new User("Tom", "123456"); user.setI(5);
		  System.out.println("Before Serialization:" + user); //ByteArrayOutputStream
		  //buf = new ByteArrayOutputStream();
		  
		  // 把User对象序列化到一个文件中 
		  ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("object.dat")); 
		  o.writeObject(user);
		 

		// 从字节缓存中反序列化User对象
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.dat"));
		User user1 = (User) in.readObject();
		
		System.out.println("After Serialization:" + user1);
		System.out.println(user1.getI());
	}
}

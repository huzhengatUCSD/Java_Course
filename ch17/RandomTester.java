package ch17;

import java.io.*;

public class RandomTester {
	public static void main(String args[]) throws IOException {
		String filename = "test.dat";
		System.out.println(filename);

		RandomAccessFile rf = new RandomAccessFile(filename, "rw");
		for (int i = 0; i < 10; i++)
			rf.writeLong(i * 1000);
		System.out.println("当前指针偏移 " + rf.getFilePointer());
		rf.seek(5 * 8); // 从文件开头开始，跳过第5个long数据，接下来写第6个long数据
		System.out.println("当前指针偏移 " + rf.getFilePointer());
		rf.writeLong(123456);

		rf.seek(0); // 把读写指针定位到文件开头
		System.out.println("当前指针偏移 " + rf.getFilePointer());
		for (int i = 0; i < 10; i++)
			System.out.println("Value" + i + ":" + rf.readLong());

		rf.close();
	}
}

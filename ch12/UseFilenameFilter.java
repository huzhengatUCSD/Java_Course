package ch12;

import java.io.*;

public class UseFilenameFilter {
	public static void main(String args[]) throws Exception {
		File dir1 = new File(".");

		FilenameFilter filter = new FilenameFilter() { // 匿名类
			public boolean accept(File dir, String name) {
				System.out.println("根路径：" + dir.getPath() + " 子路径：" + name);
				File currFile = new File(dir, name);
				if (currFile.isDirectory() && name.matches("ch.*"))
					return true;
				else
					return false;
			}
		};

		// 返回目标目录下以“ch”开头的目录清单
		String[] lists = dir1.list(filter);
		System.out.println("目标目录下的符合过滤条件的文件或目录为:");
		for (int i = 0; i < lists.length; i++)
			System.out.println(lists[i]);
	}
}

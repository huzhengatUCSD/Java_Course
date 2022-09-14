//TestToken.java
package ch10;

import java.util.*;

public class TestToken {
	public static void main(String args[]) {
		
		String[] tokens = "Java#HTML#Perl".split("#",0);
		for (int i = 0; i < tokens.length; i++) 
			  System.out.println(tokens[i] + " ");

		// 构造StringTokenizer对象
		StringTokenizer st = new StringTokenizer(
				"this| is, a ;Java programming", ", |;");
		// 在字符串中匹配默认的分隔符
		while (st.hasMoreTokens()) {
			//打印当前分隔符与下一个分隔符之间的内容
			System.out.println(st.nextToken());
		}
		StringTokenizer st1 = new StringTokenizer("we ,are ; student", ",; ",true);
		while (st1.hasMoreTokens()) {
			//打印当前分隔符与下一个分隔符之间的内容
			System.out.println(st1.nextToken());
		}
	}
}

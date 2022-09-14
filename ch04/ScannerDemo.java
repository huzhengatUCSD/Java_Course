package ch04;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str= scan.next();
            System.out.println("输入的数据为：" + str);
            System.out.println("字符串长度为：" + str.length());
        }
        
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str= scan.nextLine();
            System.out.println("输入的数据为：" + str);
            System.out.println("字符串长度为：" + str.length());
            System.out.println(str.charAt(str.length()-1));
        }
        
        scan.close();
    }
}
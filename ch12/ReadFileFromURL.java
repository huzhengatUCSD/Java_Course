package ch12;

import java.util.Scanner;
import java.net.*;

public class ReadFileFromURL {
  public static void main(String[] args) {
    System.out.print("Enter a URL: ");  //https://www.bupt.edu.cn/index.html
    String URLString = new Scanner(System.in).next();
       
    try {
      URL url = new URL(URLString); 
      int count = 0;
      Scanner input = new Scanner(url.openStream());
      while (input.hasNext()) {
        String line = input.nextLine();
        System.out.println(line);
        count += line.length();
      } 
      
      System.out.println("The file size is " + count + " bytes");
    }
    catch (java.net.MalformedURLException ex) {
      System.out.println("Invalid URL");
    }
    catch (java.io.IOException ex) {
      System.out.println("IO Errors");
    }
  }
}   

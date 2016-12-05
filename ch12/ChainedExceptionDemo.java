package ch12;

import java.io.IOException;


public class ChainedExceptionDemo {
  public static void main(String[] args) {
    try {
      method1();
    }
    catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
  }

  public static void method1() throws ClassNotFoundException {
    try {
      method2();
    }
    catch (IOException ex) {
      throw new ClassNotFoundException("New info from method1", ex);
    }
  }

  public static void method2() throws IOException {
    throw new IOException("New info from method2");
  }
}

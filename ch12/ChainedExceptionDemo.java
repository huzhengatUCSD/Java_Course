package ch12;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ChainedExceptionDemo {
  public static void main(String[] args) {
    try {
      method1();
    }
    catch (IOException ex) {
      ex.printStackTrace();
//      ex.getCause().printStackTrace();
    }
  }

  public static void method1() throws IOException {
    try {
      method2();
    }
    catch (IOException ex) {
      /*IOException ce= new IOException("New IOException occurs at method1");
      ce.initCause(ex);
      throw ce;*/
      throw new IOException("New IOException occurs at method1",ex);
    }
  }

  public static void method2() throws FileNotFoundException {
    throw new FileNotFoundException("file not found exception occurs at method2");
  }
}

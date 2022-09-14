package ch17;

import java.io.*;

public class TestFileStream {
  public static void main(String[] args) {
    try (
      // Create an output stream to the file
      FileOutputStream output = new FileOutputStream("temp1.dat");
    ) {
      // Output values to the file
      for (int i = 246; i <= 265 ; i++)
        output.write(i);
    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    try (
      // Create an input stream for the file
      FileInputStream input = new FileInputStream("temp1.dat");
    ) {
      // Read values from the file
      int value;
      while ((value = input.read()) != -1)
        System.out.print(value + " ");
    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}

package ch12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner; 

public class DirectorySize {
  public static void main(String[] args) throws IOException{
    // Prompt the user to enter a directory or a file
    System.out.print("Enter a directory or a file: ");    
    Scanner input = new Scanner(System.in);
    String directory = input.nextLine();
    File dirx=new File(directory);
    System.out.println(dirx.getCanonicalPath());
    // Display the size
    System.out.println(getSize(dirx) + " bytes");
  }

  public static long getSize(File file) {
    long size = 0; // Store the total size of all files

    if (file.isDirectory()) {
      File[] files = file.listFiles(); // All files and subdirectories
      for (int i = 0; files != null && i < files.length; i++) {
        size += getSize(files[i]); // Recursive call
      }
    }
    else { // Base case
      size += file.length();
    }

    return size;
  }
}

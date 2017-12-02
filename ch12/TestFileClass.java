package ch12;

import java.io.IOException;

public class TestFileClass {
  public static void main(String[] args) throws IOException {
    java.io.File file = new java.io.File("../Java_Course/./res/ch01/hello_unicode.txt");
    System.out.println("Does it exist? " + file.exists());
    System.out.println("The file has " + file.length() + " bytes");
    System.out.println("Can it be read? " + file.canRead());
    System.out.println("Can it be written? " + file.canWrite());
    System.out.println("Is it a directory? " + file.isDirectory());
    System.out.println("Is it a file? " + file.isFile());
    System.out.println("Is it absolute? " + file.isAbsolute());
    System.out.println("Is it hidden? " + file.isHidden());
    System.out.println("Absolute path is " +
      file.getAbsolutePath());
    System.out.println("Canonical path is " +
    	      file.getCanonicalPath());
    System.out.println("File name is " +
  	      file.getName());
    System.out.println("Parent Directory of the file is " +
  	      file.getParent());
    System.out.println("Last modified on " +
      new java.util.Date(file.lastModified()));
  }
}

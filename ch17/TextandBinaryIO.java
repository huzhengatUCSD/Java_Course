package ch17;

import java.io.*;

public class TextandBinaryIO {
    public static void main(String[] args) throws Exception {
        File file = new File("test.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        try (
                // Create a file
                PrintWriter output = new PrintWriter(file);
        ) {
            // Write formatted output to the file
            output.print(199);
            output.print("199");

        }

        File file1 = new File("temp1.dat");
        if (file1.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }
        try (
                // Create an input stream for the file
                FileOutputStream bout = new FileOutputStream(file1);
                //DataOutputStream output=new DataOutputStream(bout);
        ) {
            // Read values from the file
              bout.write(199);
//            output.writeInt(232323);
        }
    }
}

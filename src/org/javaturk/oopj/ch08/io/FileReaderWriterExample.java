package org.javaturk.oopj.ch08.io;

import java.io.*;
import java.util.Date;

public class FileReaderWriterExample {

    public static void main() throws IOException {
        String path = "src/org/javaturk/oopj/ch08/io/file.txt";

        // First write
        String text = "Date: ";
        Writer writer = new FileWriter(path, true);
        writer.write(text);
        writer.write(String.valueOf(new Date()));
        writer.write("\n");
        writer.close();

        // Then read it
        Reader reader = new FileReader(path);
        int c;
        while((c = reader.read()) != -1){
            System.out.print((char) c);
        }
        reader.close();
    }
}

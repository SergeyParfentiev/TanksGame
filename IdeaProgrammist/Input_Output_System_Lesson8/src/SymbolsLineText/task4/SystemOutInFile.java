package SymbolsLineText.task4;

import java.io.*;

/**
 * Created by Byblik272 on 4/2/2016.
 */
public class SystemOutInFile {
    public static void main(String[] args) throws IOException{

        File file = new File("SystemOutInFile.txt");

        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream writer = new BufferedOutputStream(fos);

        PrintStream ps = new PrintStream(writer);

        System.setOut(ps);
        System.out.println("First line");
        System.out.println("Second line");

        writer.close();
    }
}

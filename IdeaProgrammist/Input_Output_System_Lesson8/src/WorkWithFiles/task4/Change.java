package WorkWithFiles.task4;

import java.io.*;

/**
 * Created by Byblik272 on 31/1/2016.
 */
public class Change {
    public static void main(String[] args) throws IOException {

        String text = "Hello World!";
        byte[] textInBytes = text.getBytes();

        InputStream inputStream = new ByteArrayInputStream(textInBytes);

        printStreamData(inputStream);
    }

    private static void printStreamData(InputStream stream) throws IOException {

        File file = new File("InputStream.txt");
        boolean append = true;
        FileWriter fileWriter = new FileWriter(file, append);

        while(stream.available() > 0) {
            fileWriter.write(stream.read());
        }

        fileWriter.write("\r\n");
        fileWriter.close();
    }
}

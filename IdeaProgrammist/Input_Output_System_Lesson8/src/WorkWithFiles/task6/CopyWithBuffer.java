package WorkWithFiles.task6;

import java.io.*;

/**
 * Created by Byblik272 on 2/2/2016.
 */
public class CopyWithBuffer {
    public static void main(String[] args) {

        File firsFile = new File("/WorkWithFiles/task6.txt");
        String text = "I use text with the aid of Buffer!\r\nLoL\r\nNextLine";
        CopyWithBuffer.write(firsFile, text);

        CopyWithBuffer.copyFile(firsFile);

    }

    public static void copyFile(File file) {
        String copiedFileName = "/WorkWithFiles/task6Copy.txt";
        File secondFile = new File(copiedFileName);

        StringBuilder builder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(file), 256)) {
            String s;
            while ((s = br.readLine()) != null) {
                builder.append(s);
                builder.append("\r\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        CopyWithBuffer.write(secondFile, builder.toString());
    }

    public static void write(File file, String data) {

        String fileName = String.valueOf(file);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName), 256))
        {
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

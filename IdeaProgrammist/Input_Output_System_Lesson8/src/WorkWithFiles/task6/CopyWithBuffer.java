package WorkWithFiles.task6;

import java.io.*;

/**
 * Created by Byblik272 on 2/2/2016.
 */
public class CopyWithBuffer {
    public static void main(String[] args) throws IOException {

        File firsFile = new File("/WorkWithFiles/task6.txt");
        String text = "I use text with the aid of Buffer!";
        CopyWithBuffer.write(String.valueOf(firsFile), text);

        CopyWithBuffer.copyFile(firsFile);

    }

    public static void copyFile(File file) throws IOException{
        StringBuilder sb = new StringBuilder();

                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis, 256);

            int i;
            while((i = bis.read()) != -1) {
                sb.append((char) i);
            }

        String copiedFileName = "/WorkWithFiles/task6Copy.txt";
        File secondFile = new File(copiedFileName);

        CopyWithBuffer.write(String.valueOf(secondFile), sb.toString());

    }

    public static void write(String fileName, String data) {

        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                BufferedOutputStream bos = new BufferedOutputStream(fos, 256)
        ) {

            bos.write(data.getBytes());
            bos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

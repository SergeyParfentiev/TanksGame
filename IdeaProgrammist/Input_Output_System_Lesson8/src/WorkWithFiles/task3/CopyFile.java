package WorkWithFiles.task3;

import java.io.*;

/**
 * Created by Byblik272 on 30/1/2016.
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {


        File firstFile = new File("/WorkWithFiles/task1.txt");
        String text = "LoLy";
        CopyFile.write(String.valueOf(firstFile), text);

        CopyFile.copyFile(firstFile);

    }

    public static void copyFile(File file) throws IOException {

        StringBuilder sb = new StringBuilder();

        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        File secondFile = new File("/WorkWithFiles/task1Copy.txt");
        secondFile.createNewFile();

        CopyFile.write(String.valueOf(secondFile), sb.toString());
    }

    public static void write(String fileName, String text) {
        File file = new File(fileName);

        try {
            if(!file.exists()){
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}

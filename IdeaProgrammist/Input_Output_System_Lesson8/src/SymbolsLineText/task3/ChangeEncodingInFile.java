package SymbolsLineText.task3;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by Byblik272 on 4/2/2016.
 */
public class ChangeEncodingInFile {
    public static void main(String[] args) throws IOException {

        File file = new File("ChangeEncodingInFile.txt");
        String text = "I encoding the text!\r\nStill encoding!";

        String current = String.valueOf(StandardCharsets.ISO_8859_1);
        String needed = String.valueOf(StandardCharsets.ISO_8859_1);

        writeInFile(file, text);
        changeEncoding(file, current, needed);
    }

    public static void changeEncoding(File file, String currentEncoding, String neededEncoding) throws IOException{
        StringBuilder builder = new StringBuilder();

        FileInputStream fis = new FileInputStream(file.getName());
        InputStreamReader reader = new InputStreamReader(fis, currentEncoding);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String str;
        while ((str = bufferedReader.readLine()) != null) {
            builder.append(str);
            builder.append("\r\n");
        }
        bufferedReader.close();

        FileOutputStream fos = new FileOutputStream(file.getName());
        OutputStreamWriter writer = new OutputStreamWriter(fos, neededEncoding);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write(builder.toString());

        bufferedWriter.close();
    }

    public static void writeInFile(File file, String text) {
        try (
                FileOutputStream fos = new FileOutputStream(file.getName());
                OutputStreamWriter writer = new OutputStreamWriter(fos, StandardCharsets.ISO_8859_1);
                BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

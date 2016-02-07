package SymbolsLineText.task5;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Created by Byblik272 on 6/2/2016.
 */
public class WorkWithZip {
    public static void main(String[] args) throws IOException {

        String folderName = "/WorkWithFilesT";
        zip(folderName);
        String zipName = "/WorkWithFilesT.zip";
        unZip(zipName);

    }

    private static void zip(String filename) throws IOException {
        File file = new File(filename);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(filename + ".zip"));

        createZip(file, out);
        out.close();
    }

    private static void createZip(File file, ZipOutputStream out) throws IOException {
        if(file.listFiles() == null) {
            out.putNextEntry(new ZipEntry(file.getName()));
            write(new FileInputStream(file), out);
        } else {
            for (File f : file.listFiles()) {
                if (f.isDirectory())
                    createZip(f, out);
                else {
                    out.putNextEntry(new ZipEntry(f.getPath()));
                    write(new FileInputStream(f), out);
                }
            }
        }
    }

    public static void unZip(String zipName) throws IOException{
        File file = new File(zipName);
        ZipFile zip = new ZipFile(zipName);
        Enumeration en = zip.entries();

        while (en.hasMoreElements()) {

            ZipEntry entry = (ZipEntry) en.nextElement();
            System.out.println(entry.getName());

            File fileInZip = new File(file.getParent(), entry.getName());
            if (entry.isDirectory()) {
                fileInZip.mkdirs();
            }
            File parent = fileInZip.getParentFile();
            if (parent != null) {
                parent.mkdirs();
            }

            InputStream is = zip.getInputStream(entry);
            OutputStream os = new BufferedOutputStream(new FileOutputStream(fileInZip));
            write(is, os);
            os.close();
        }
    }
    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
    }
}

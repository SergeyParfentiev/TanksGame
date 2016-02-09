package Serialization.task1;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Byblik272 on 8/2/2016.
 */
public class URLReader {
    public static void main(String[] args) throws Exception{

        URL url = new URL("http://www.ex.ua");
        String dirName = "/" + url.getHost().substring(4);
        String fileName = "/" + url.getHost().substring(4) + ".txt";
        String fullFileName = dirName + fileName;

        File dir = new File(dirName);
        dir.mkdirs();

        URLConnection openConnection = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fullFileName)));
        String s;
        while ((s = br.readLine()) != null) {
            bw.write(s);
        }
        br.close();
        bw.close();
    }
}

package WorkWithFiles.task1;

import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 30/1/2016.
 */
public class TreeOfCatalogues {
    public static void main(String[] args) throws IOException {

        File dir = new File("/WorkWithFiles");
        dir.mkdir();

        File newFile = new File(String.valueOf(dir) + "/task1.txt");
        newFile.createNewFile();

        File Catalogue = new File("/");
        if (Catalogue.isDirectory()) {
            for (File file : Catalogue.listFiles()) {
                System.out.println(file.getCanonicalPath());
            }
        }
    }
}

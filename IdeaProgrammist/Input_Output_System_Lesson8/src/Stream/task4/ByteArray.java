package Stream.task4;

import java.io.ByteArrayInputStream;

/**
 * Created by Byblik272 on 27/1/2016.
 */
public class ByteArray {
    public static void main(String[] args) {

        byte spy = (byte) 400;
        byte[] bytes = {100, 99, -30, spy, 4};

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        printStreamData(inputStream);
    }

    private static void printStreamData(ByteArrayInputStream stream) {
        int b;
//        while ((b = stream.read()) != -1) {
//            System.out.println(b);
//        }
        while(stream.available() > 0){
            System.out.println(stream.read());
        }
    }
}

package task2_Try_Catch;

import com.sun.imageio.plugins.common.InputStreamAdapter;

import java.net.InetSocketAddress;

/**
 * Created by Byblik272 on 24/11/2015.
 */
public class Exception_In_Catch {
    public static void main(String[] args) {

        try {
            System.out.println("Exception here");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Go here");
            throw new IllegalStateException();

        } finally {
            System.out.println("Always go there");
            System.out.println("I want to be printed!");
        }

    }
}

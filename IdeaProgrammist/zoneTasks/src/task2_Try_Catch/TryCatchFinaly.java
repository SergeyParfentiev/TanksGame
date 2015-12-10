package task2_Try_Catch;

/**
 * Created by Byblik272 on 24/11/2015.
 */
public class TryCatchFinaly {
    public static void main(String[] args) {

        try {
            System.out.println("Not Exception here");
            return;
        } catch (Exception e) {
            System.out.println("Never been here");
            e.printStackTrace();

        } finally {
            System.out.println("Always go there");
            System.out.println("I want to be executed!");
        }

    }
}

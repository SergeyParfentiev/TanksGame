package Collection_Grouping_Associations.task5;

/**
 * Created by Byblik272 on 3/3/2016.
 */
public class LauncherIdGenerator {
    public static void main(String[] args) {

        final IdGenerator generator = new IdGenerator(100);

        for(int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(generator.getNextId());
                }
            }).start();
        }
    }
}

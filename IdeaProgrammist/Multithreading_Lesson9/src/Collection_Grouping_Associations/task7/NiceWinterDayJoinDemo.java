package Collection_Grouping_Associations.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Byblik272 on 27/2/2016.
 */
public class NiceWinterDayJoinDemo {

    public static void main(String[] args) throws Exception{

        System.out.println("Good morning everyone we are opened!!!");

        final SkatingRink skatingRink = new SchoolSkatingRink();

        final Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Future> futures = new ArrayList<>();

        try {
            for (int i = 1; i < 11; i++) {

                final Skater skater = new Skater("Skater " + i);

                futures.add(executor.submit(new Runnable() {
                    @Override
                    public void run() {

                        Skates skates = new Skates();
                        skatingRink.getSkates(skates, skater);
                        sleep(random.nextInt(2000));
                        skatingRink.returnSkates(skates, skater);
                    }
                }));

                sleep(random.nextInt(1000));
            }

            for (Future future : futures) {
                future.get();
            }
        } finally {
            executor.shutdown();
        }

        System.out.println("\nGood night. See you tomorrow!!!");
    }

    private static void sleep(int timeout) {
        try {
            Thread.currentThread().sleep(timeout);
        } catch (Exception e) {

        }
    }
}

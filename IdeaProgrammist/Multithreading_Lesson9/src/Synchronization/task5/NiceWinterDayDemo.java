package Synchronization.task5;

import java.util.Random;

/**
 * Created by Byblik272 on 27/2/2016.
 */
public class NiceWinterDayDemo {

    public static void main(String[] args) {

        System.out.println("Good morning everyone we are opened!!!");

        final SkatingRink skatingRink = new SchoolSkatingRink();

        final Random random = new Random();

        for(int i = 1; i < 110; i++) {

            final Skater skater = new Skater("Skater " + i);

            new Thread(new Runnable() {
                @Override
                public void run() {

                    Skates skates = new Skates();
                    skatingRink.getSkates(skates, skater);
                    sleep(random.nextInt(2000));
                    skatingRink.returnSkates(skates, skater);
                }
            }).start();

            sleep(random.nextInt(1000));
        }
    }

    private static void sleep(int timeout) {
        try {
            Thread.currentThread().sleep(timeout);
        } catch (Exception e) {

        }
    }
}

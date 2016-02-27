package Synchronization.task5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byblik272 on 27/2/2016.
 */
public class SchoolSkatingRink implements SkatingRink {

    private volatile int skatesCount = 4;

    private volatile int number = 1;

    private List listSkaters;

    public SchoolSkatingRink() {
        listSkaters = new ArrayList();
    }

    @Override
    public void getSkates(Skates skates, Skater skater) {
        if(skatesCount == 0) {
           synchronized (skater) {
                try {
                    listSkaters.add(skater);
                    skater.wait();
                    System.out.println(skater.getName() + " get skates №" + number++);
                    skatesCount--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println(skater.getName() + " get skates №" + number++);
        }
        skatesCount--;
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {

        number--;

        System.out.println(skater.getName() + " return skates №" + number);

        if(listSkaters.size() != 0) {

            synchronized (listSkaters.get(0)) {
                listSkaters.get(0).notify();
                listSkaters.remove(0);
            }
        }
        skatesCount++;
    }

    public int getSkatesCount() {
        return skatesCount;
    }
}

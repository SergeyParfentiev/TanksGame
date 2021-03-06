package Synchronization.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Byblik272 on 27/2/2016.
 */
public class SchoolSkatingRink implements SkatingRink {

    private volatile int skatesCount = 5;

    private volatile int number = 1;

    final private int minCount = 0;

    Lock lock;

    private List listSkaters;
    private List listSkates;

    public SchoolSkatingRink() {
        skatesCount++;
        listSkaters = new ArrayList();
        listSkates = new ArrayList();
        lock = new ReentrantLock();
    }

    @Override
    public void getSkates(Skates skates, Skater skater) {
        skatesCount--;
        if(skatesCount < minCount) {
           synchronized (skater) {
                try {
                    listSkaters.add(skater);
                    skater.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        lock.lock();
        if(listSkates.isEmpty()) {
            skates.count = number;
            System.out.println(skater.getName() + " get skates №" + skates.count);
            number++;
        } else {
            skates.count = (int) listSkates.get(minCount);
            System.out.println(skater.getName() + " get skates №" + skates.count);
            listSkates.remove(minCount);
        }
        lock.unlock();
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        skatesCount++;

        System.out.println(skater.getName() + " return skates №" + skates.count);

        listSkates.add(skates.count);

        if(listSkaters.size() != minCount) {

            synchronized (listSkaters.get(minCount)) {
                listSkaters.get(minCount).notify();
                listSkaters.remove(minCount);
            }
        }
    }
}

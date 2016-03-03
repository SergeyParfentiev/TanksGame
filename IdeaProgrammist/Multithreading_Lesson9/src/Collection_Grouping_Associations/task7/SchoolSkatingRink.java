package Collection_Grouping_Associations.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Byblik272 on 27/2/2016.
 */
public class SchoolSkatingRink implements SkatingRink {

    private volatile int number = 1;

    final private int minCount = 0;

    Lock lock;

    private List listSkates;

    public SchoolSkatingRink() {
        listSkates = new ArrayList();
        lock = new ReentrantLock();
    }

    @Override
    public void getSkates(Skates skates, Skater skater) {

        lock.lock();
        if(listSkates.isEmpty()) {
            skates.number = number;
            System.out.println(skater.getName() + " get skates №" + skates.number);
            number++;
        } else {
            skates.number = (int) listSkates.get(minCount);
            System.out.println(skater.getName() + " get skates №" + skates.number);
            listSkates.remove(minCount);
        }
        lock.unlock();
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {

        System.out.println(skater.getName() + " return skates №" + skates.number);

        listSkates.add(skates.number);
    }
}

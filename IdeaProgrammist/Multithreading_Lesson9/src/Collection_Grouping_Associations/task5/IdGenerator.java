package Collection_Grouping_Associations.task5;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Byblik272 on 3/3/2016.
 */
public class IdGenerator {

    private AtomicLong id;

    public IdGenerator(int i) {
        int firstId = new Random().nextInt(i);
        id = new AtomicLong(firstId);
    }

    public long getNextId() {
        return id.getAndIncrement();
    }
}

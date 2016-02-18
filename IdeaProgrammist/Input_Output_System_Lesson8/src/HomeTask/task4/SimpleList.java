package HomeTask.task4;

import java.util.Iterator;

/**
 * Created by Byblik272 on 18/2/2016.
 */
public interface SimpleList<T> {

    void add(T object);

    boolean contains(T object);

    void remove(T object);

    int size();

    Iterator<T> iterator();
}

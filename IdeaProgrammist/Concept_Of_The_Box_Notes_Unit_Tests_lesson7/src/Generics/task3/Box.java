package Generics.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byblik272 on 14/1/2016.
 */
public class Box<T> {

    private List<T> list = new ArrayList<>();


    public List<T> getItems() {
        return list;
    }

    public void setItem(T item) {
        list.add(item);
    }

    public T getItem(int i) {
        if(i < list.size()) {
            return list.get(i);
        }else {
            return list.get(list.size() - 1);
        }
    }

    public void remove(T item) {
        list.remove(item);
    }
}

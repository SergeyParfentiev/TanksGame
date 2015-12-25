package HomeTask.Task8;

import java.util.Iterator;

/**
 * Created by Byblik272 on 24/12/2015.
 */
public class SimpleArrayList implements Iterable {

    private int size = 0;
    private Object[] array = new Object[size];
    private Object[] temp;

    public void add(Object object) {
        temp = new Object[array.length];
        System.arraycopy(array, 0, temp, 0, array.length);
        size++;
        array = new Object[size];
        System.arraycopy(temp, 0, array, 0, temp.length);
        array[size - 1] = object;
    }

    public void remove(Object object) {
        int tmp = 0;
        int idx = 0;
        if(object == null) {
            for(int i = 0; i < size; i++) {
                if(array[i] == null) {
                 tmp = i;
                    idx++;
                    break;
                }
            }
        } else {
            for(int i = 0; i < size; i++) {
                if(object.equals(array[i])) {
                    tmp = i;
                    idx++;
                    break;
                }
            }
        }
        if(idx > 0) {
            temp = new Object[array.length - 1];
            System.arraycopy(array, 0, temp, 0, tmp);
            System.arraycopy(array, tmp + 1, temp, tmp, array.length - tmp - 1);
            size--;
            array = new Object[size];
            array = temp;

        }

    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        else return false;
    }

    @Override
    public Iterator iterator() {
        return new SALIterator();
    }

    private class SALIterator implements Iterator{

        private int next;
        @Override
        public boolean hasNext() {
            next++;
            return (size > 0 && next <= size);
        }

        @Override
        public Object next() {
            return array[next - 1];
        }

        @Override
        public void remove() {

        }
    }
}

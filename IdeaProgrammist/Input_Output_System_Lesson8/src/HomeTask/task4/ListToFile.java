package HomeTask.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Byblik272 on 18/2/2016.
 */
public class ListToFile implements SimpleList, Serializable, Iterable<Object>{

    private List<Object> list;
    private File file = new File("/ListToFile.txt");

    @Override
    public void add(Object object) {
        readFromFile();
        list.add(object);
        writeToFile();
    }

    @Override
    public boolean contains(Object object) {
        return list.contains(object);
    }

    @Override
    public void remove(Object object) {
        readFromFile();
        list.remove(object);
        writeToFile();
    }

    @Override
    public int size() {
        readFromFile();
        return list.size();
    }

    @Override
    public Iterator iterator() {
        return new listIterator();
    }

    private class listIterator implements Iterator<Object> {
        private int next = 0;

        @Override
        public boolean hasNext() {
            return next < list.size();
        }

        @Override
        public Object next() {
            if(hasNext()) {
                return list.get(next++);
            }
            throw new IllegalStateException("No elements");
        }

        @Override
        public void remove() {
        }
    }

    private void readFromFile() {
        list = new ArrayList<>();

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            ObjectInputStream ois = new ObjectInputStream(bis)) {
            while (bis.available() > 0) {
                list.add(ois.readObject());
            }
        } catch (Exception e) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void writeToFile() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for(Object o : list) {
                oos.writeObject(o);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

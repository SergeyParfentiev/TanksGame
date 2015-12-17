package List.OwnImplementation_Task11;

import java.util.Iterator;

/**
 * Created by Byblik272 on 12/12/2015.
 */
public class SimpleLinkedList implements Iterable{
    private Node first;
    private int size;
    private  Node last;

    @Override
    public Iterator iterator() {
        return new SllIterator();
    }

     class SllIterator implements Iterator{

        private Node node = first;
         private Node once = first;
        @Override
        public boolean hasNext() {
            if(node != null && node.ref != null) {
                return true;
            }else {
                return false;
            }
        }

        @Override
        public Object next() {
            if(once != null){
                once = null;
                return node.object;
            }
            if(hasNext()) {
                node = node.ref;
                return node.object;
            }
            throw new IllegalStateException("No elements");
        }

        @Override
        public void remove() {

        }
    }
    private class Node {
        Object object;
        Node ref;
    }

    public void addFirst(Object o) {
        Node node = new Node();
        node.object = o;
        if(first == null) {
            first = node;
            last = node;
        } else {
            node.ref = first;
            first = node;
        }
        size++;
    }
    public void addLast(Object o) {
        Node node = new Node();
        node.object = o;
        if(first == null) {
            first = node;
        }else {
            last.ref = node;

        }
        last = node;
        size++;
    }
    public void addAfter(Object find, Object insert) {
        Node before = first;
        Node next = first;
        Node paste = new Node();
        paste.object = insert;
        for(int i = 0; i < size; i++) {
            if(first == null || (i == size && next.object != find)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    throw new IllegalStateException();

                }
            }
            next = next.ref;
        }
        if(next == find) {
            last.ref = paste;
            last = paste;
            size++;
        }else {
            for (int i = 0; i < size; i++) {
                if (before.object == find) {
                    next = before.ref;
                    before.ref = paste;
                    paste.ref = next;
                    size++;
                    break;
                }else {
                    before = before.ref;
                }
            }
        }
    }


    public void printList() {
        if(size == 0) {
            System.out.println("List is empty");
        }
        System.out.print(" { ");
        Node cp = first;
        while (cp.ref != null) {
            System.out.print(cp.object + ", ");
            cp = cp.ref;
        }
        System.out.println(cp.object + " }");
    }
    public int getSize() {
        return size;
    }

    public Node getRoot() {
        return first;
    }


}

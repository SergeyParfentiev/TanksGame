package List.OwnImplementation_Task7;

/**
 * Created by Byblik272 on 12/12/2015.
 */
public class SimpleLinkedList {
    private Node first;
    private int size;
    private  Node last;

    public SimpleLinkedList() {
        size = 0;
    }

    private class Node {
        Object object;
        Node ref;
    }

    public void addFirst(Object o) {
        Node node = new Node();
        node.object = o;
        if(first != null) {
            node.ref = first;
        }
        first = node;
        size++;
    }
    public void addLast(Object o) {
        if(first == null) {
            Node node = new Node();
            node.object = o;
            first = node;
            last = node;
        }else {
            Node node = new Node();
            node.object = o;
            last.ref = node;
            last = node;
        }
        size++;
    }
    public void addAfter(Object o, Object obj) {
    }
    public int getSize() {
        return size;
    }

    public Node getRoot() {
        return first;
    }

}

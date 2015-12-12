package List.OwnImplementation_Task3;

import List.OwnImplementation.Node;

/**
 * Created by Byblik272 on 12/12/2015.
 */
public class SimpleLinkedList {
    private Node root;
    private int size;

    public SimpleLinkedList() {
        size = 0;
    }

    private class Note {
        Object object;
        Note note;
    }

    public void addFirst(Object o) {
    }
    public void addLast(Object o) {
    }
    public void addAfter(Object o, Object obj) {
    }
    public int getSize() {
        return size;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

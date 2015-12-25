package HomeTask.task9;

import java.util.LinkedList;

/**
 * Created by Byblik272 on 25/12/2015.
 */
public class Stack {

    LinkedList<Object> linkedList = new LinkedList<Object>();

    public void push(Object object){
        linkedList.addLast(object);
    }

    public Object pop(){
        Object object = linkedList.getLast();
        linkedList.removeLast();
        return object;
    }

    public Object peak(){
        Object object = linkedList.getLast();
        return object;
    }
}

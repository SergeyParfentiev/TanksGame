package List.OwnImplementation_Task13;


/**
 * Created by Byblik272 on 17/12/2015.
 */
public class LauncherSllIterator {
    public static void main(String[] args) {

        SimpleLinkedList sll = new SimpleLinkedList();

        sll.addFirst("2");
        sll.addFirst("1");
        sll.addLast("3");
        sll.addAfter("3", "5");
        sll.addAfter("3", "4");
        sll.remove("2");
        sll.remove("4");
        sll.addFirst("0");
        sll.addLast("7");
        sll.addAfter("7", "5");
        sll.addLast("6");
        sll.addLast("8");
        sll.addAfter("6", "7");
        sll.addFirst("Haha");


        for(Object o : sll) {
            System.out.println(o);
        }
    }
}

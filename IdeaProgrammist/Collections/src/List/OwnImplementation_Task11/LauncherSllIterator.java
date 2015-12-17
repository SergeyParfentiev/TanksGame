package List.OwnImplementation_Task11;

/**
 * Created by Byblik272 on 17/12/2015.
 */
public class LauncherSllIterator {
    public static void main(String[] args) {

        SimpleLinkedList sll = new SimpleLinkedList();

        sll.addFirst("2");
        sll.addFirst("1");
        sll.addLast("3");
        sll.addAfter("3", "4");
        sll.addAfter("3", "5");


        for(Object o : sll) {
            System.out.println(o);
        }
    }
}

package List.OwnImplementation_Task16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Byblik272 on 18/12/2015.
 */
public class SortList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Irina");
        list.add("Igor");
        list.add("Oleg");
        list.add("Alexey");
        list.add("Alexander");
        list.add("Nastya");
        list.add("Dmitriy");
        list.add("Misha");
        list.add("Maxim");
        list.add("Pasha");

        Collections.sort(list);

        for (String names : list) {
            System.out.println(names);
        }
        System.out.println("\n");

        Collections.sort(list, new MyComparator());

        for (String names : list) {
            System.out.println(names);
        }
    }
}

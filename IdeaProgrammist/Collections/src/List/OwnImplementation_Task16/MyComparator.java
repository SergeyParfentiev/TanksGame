package List.OwnImplementation_Task16;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Byblik272 on 18/12/2015.
 */
public class MyComparator implements Comparator<String>{


    @Override
    public int compare(String o1, String o2) {
        if(o1.compareTo(o2) > 0){
            return -1;
        }
        if(o1.compareTo(o2) < 0) {
            return 1;
        }
        return 0;
    }
}

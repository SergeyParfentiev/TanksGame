package Calendar.task4;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Byblik272 on 31/12/2015.
 */
public class MyBirthdayDay {

    public void MyBirthdayDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        Date bithday = new Date(0, 5, 9);

        System.out.println(simpleDateFormat.format(bithday)) ;
    }
}

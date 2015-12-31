package Calendar.task2;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Byblik272 on 31/12/2015.
 */
public class MyBirthday {

    public void MyBirthdayDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
        Date bithday = new Date(0, 5, 9);

        System.out.println(format.format(bithday));
    }
}

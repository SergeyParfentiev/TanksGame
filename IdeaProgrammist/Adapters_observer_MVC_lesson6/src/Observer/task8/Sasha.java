package Observer.task8;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Byblik272 on 9/1/2016.
 */
public class Sasha implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Stock) {
            System.out.println(this.getClass().getSimpleName() + " notified. Event: " + ((Stock) arg).getName());
        } else {
            System.out.println(this.getClass().getSimpleName() + " notified.");
        }
    }
}

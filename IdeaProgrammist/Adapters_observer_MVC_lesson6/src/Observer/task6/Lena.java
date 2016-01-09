package Observer.task6;

/**
 * Created by Byblik272 on 9/1/2016.
 */
public class Lena implements Subscriber {

    @Override
    public void notification() {
        System.out.println(this.getClass().getSimpleName() + " notified.");
    }
}

package Observer.task6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byblik272 on 9/1/2016.
 */
public class Newspaper implements Publisher{

    private List<Subscriber> subscribers;

    public Newspaper(){
        subscribers = new ArrayList<>();
    }
    @Override
    public void latestIssue() {
        double d = Math.random();
        if (d < 0.5 || d > 10.0) {
            System.out.println(this.getClass().getSimpleName() + ": Latest Issue is published");
            notifySubscribers();
        } else {
            System.out.println(this.getClass().getSimpleName() + ": Latest Issue isn`t published!");
        }
    }


    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.notification();
        }
    }
}

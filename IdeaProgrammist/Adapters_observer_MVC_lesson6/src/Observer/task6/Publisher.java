package Observer.task6;

/**
 * Created by Byblik272 on 9/1/2016.
 */
public interface Publisher {
    public void latestIssue();
    public void addSubscriber(Subscriber subscriber);
    public void removeSubscriber(Subscriber subscriber);
    public void notifySubscribers();
}

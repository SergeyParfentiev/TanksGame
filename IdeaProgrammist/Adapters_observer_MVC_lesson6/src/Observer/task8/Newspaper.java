package Observer.task8;

import java.util.Observable;

/**
 * Created by Byblik272 on 9/1/2016.
 */
public class Newspaper extends Observable{

    public void latestIssue() {
        double d = Math.random();
        if (d < 0.5 || d > 10.0) {
            System.out.println(this.getClass().getSimpleName() + ": Latest Issue is published");
            setChanged();
            notifyObservers();
        } else {
            System.out.println(this.getClass().getSimpleName() + ": Latest Issue isn`t published!");
        }
    }
    public void latestIssueWithStock() {
        double d = Math.random();
        if (d < 0.5 || d > 10.0) {
            System.out.println(this.getClass().getSimpleName() + ": Latest Issue is published");
            setChanged();
            notifyObservers(new Stock("Two for the price of one"));
        } else {
            System.out.println(this.getClass().getSimpleName() + ": Latest Issue isn`t published!");
        }
    }

}

package Observer.task8;

import java.util.Observer;

/**
 * Created by Byblik272 on 9/1/2016.
 */
public class PublisherJDK_Launcher {
    public static void main(String[] args) {

        Magazine magazine = new Magazine();
        Newspaper newspaper = new Newspaper();

        Observer lena = new Lena();
        Observer sasha = new Sasha();

        magazine.addObserver(lena);

        newspaper.addObserver(lena);
        newspaper.addObserver(sasha);

        for (int i = 0; i < 10; i++) {
            magazine.latestIssue();
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            newspaper.latestIssueWithStock();
            System.out.println();
        }
    }
}

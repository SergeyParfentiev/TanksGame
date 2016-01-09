package Observer.task6;

/**
 * Created by Byblik272 on 9/1/2016.
 */
public class Publisher_Launcher {
    public static void main(String[] args) {

        Publisher magazine = new Magazine();
        Publisher newspaper = new Newspaper();

        Subscriber lena = new Lena();
        Subscriber sasha = new Sasha();

        magazine.addSubscriber(lena);

        newspaper.addSubscriber(lena);
        newspaper.addSubscriber(sasha);

        for (int i = 0; i < 10; i++) {
            magazine.latestIssue();
            System.out.println();
            newspaper.latestIssue();
            System.out.println();
        }
    }
}

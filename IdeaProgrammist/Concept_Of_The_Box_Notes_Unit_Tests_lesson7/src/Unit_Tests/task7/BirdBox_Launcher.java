package Unit_Tests.task7;

/**
 * Created by Byblik272 on 14/1/2016.
 */
public class BirdBox_Launcher {
    public static void main(String[] args) {

        BirdBox<Bird> birdBox = new BirdBox();
        Duck duck1 = new Duck();
        Eagle eagle1 = new Eagle();
        Duck duck2 = new Duck();
        Eagle eagle2 = new Eagle();

        duck1.setName("Vasya");
        duck2.setName("Petya");
        eagle1.setName("Kolya");
        eagle2.setName("Gorya");

        duck1.setPrice(600);
        duck2.setPrice(600);
        eagle1.setPrice(1100);
        eagle2.setPrice(1100);

        birdBox.addBird(eagle2);
        birdBox.addBird(duck1);
        birdBox.addBird(eagle1);
        birdBox.addBird(duck2);

        birdBox.sortBirds();
        birdBox.getBirds();

        birdBox.sortBirdsByName();

        birdBox.removeBird(duck1);
        birdBox.getBirds();

        birdBox.sortBirdsByCost();
        birdBox.getBirds();
    }
}

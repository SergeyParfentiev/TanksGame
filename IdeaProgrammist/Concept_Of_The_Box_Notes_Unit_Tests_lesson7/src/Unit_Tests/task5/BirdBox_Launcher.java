package Unit_Tests.task5;

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

        duck1.setPrice(10);
        duck2.setPrice(11);
        eagle1.setPrice(0.5);
        eagle2.setPrice(0.6);

        birdBox.addBird(eagle2);
        birdBox.addBird(duck1);
        birdBox.addBird(eagle1);
        birdBox.addBird(duck2);

        birdBox.sortBirds();
 //       birdBox.getBirdsList();
        birdBox.getBirds();

        birdBox.sortBirdsByName();

        birdBox.removeBird(duck1);
//        birdBox.getBirdsList();
        birdBox.getBirds();

        birdBox.sortBirdsByCost();
        birdBox.getBirds();
    }
}

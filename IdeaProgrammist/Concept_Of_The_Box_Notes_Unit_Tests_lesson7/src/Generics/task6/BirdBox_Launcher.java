package Generics.task6;


/**
 * Created by Byblik272 on 14/1/2016.
 */
public class BirdBox_Launcher {
    public static void main(String[] args) {

        BirdBox<Bird> birdBox = new BirdBox();
        Duck duck = new Duck();

        birdBox.addBird(duck);
        birdBox.addBird(new Eagle());

        birdBox.getBirds();

        birdBox.removeBird(duck);
        birdBox.getBirds();
    }
}

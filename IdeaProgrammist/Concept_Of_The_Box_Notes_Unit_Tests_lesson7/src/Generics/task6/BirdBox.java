package Generics.task6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byblik272 on 14/1/2016.
 */
public class BirdBox<T extends Bird> {

    private List<T> birdList;

    public BirdBox() {
        birdList = new ArrayList<>();
    }

    public void addBird(T bird) {
        birdList.add(bird);
    }

    public void getBirds() {
        for(T bird : birdList) {
            System.out.println(bird.getClass().getSimpleName());
        }
        System.out.println();
    }

    public void removeBird(T bird) {
        birdList.remove(bird);
    }
}

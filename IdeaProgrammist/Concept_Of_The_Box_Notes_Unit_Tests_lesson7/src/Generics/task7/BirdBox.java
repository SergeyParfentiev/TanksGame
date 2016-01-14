package Generics.task7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public void getBirdsList() {
        for(T bird : birdList) {
            System.out.println(bird.getClass().getSimpleName());
        }
        System.out.println();
    }

    public void getBirds() {
        for(T bird : birdList) {
            System.out.println(bird.toString());
        }
        System.out.println();
    }

    public void removeBird(T bird) {
        birdList.remove(bird);
    }

    public void sortBirds() {
        Collections.sort(birdList, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
            }
        });
    }
    public void sortBirdsByName() {
        Collections.sort(birdList, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    public void sortBirdsByCost() {
        Collections.sort(birdList, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Double.valueOf(o1.getPrice()).compareTo(o2.getPrice());
            }
        });
    }
}

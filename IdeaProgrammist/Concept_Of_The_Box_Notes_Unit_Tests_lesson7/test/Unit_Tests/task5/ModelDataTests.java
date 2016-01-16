package Unit_Tests.task5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

/**
 * Created by Byblik272 on 16/1/2016.
 */
@RunWith(JUnit4.class)
public class ModelDataTests {

    Eagle eagle;
    Duck duck;
    Bird bird;
    BirdBox<Bird> birds;
    Bird[] birdsAb;
    int size = 4;

    @Before
    public void ini() {
        eagle = new Eagle();
        duck = new Duck();
        bird = new Bird() {};
        birds = new BirdBox();
        birdsAb = new Bird[size];
    }

    @Test
    public void testAge() {
        assertTrue(eagle.getAge() == 0);
    }

    @Test
    public void testColor() {
        assertTrue(duck.getColor() == null);
    }

    @Test
    public void testString() {
        assertNotNull(bird.toString());
    }

    @Test
    public void birdBoxListTest() {
        for(Bird birdAb : birdsAb) {
            birds.addBird(birdAb);
        }
        assertTrue(birds.getBirdsList().size() == size);
    }
}

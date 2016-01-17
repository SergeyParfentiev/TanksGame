package Unit_Tests.task7;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

/**
 * Created by Byblik272 on 17/1/2016.
 */
@RunWith(JUnit4.class)
public class BirdBoxTest {

    BirdBox<Bird> box;

    Duck duck1;
    Duck duck2;
    Eagle eagle1;

    @Before
    public void init() {
        box = new BirdBox<>();

        duck1 = new Duck();
        duck2 = new Duck();
        eagle1 = new Eagle();

        duck1.setPrice(500.0);
        duck2.setPrice(600);
        eagle1.setPrice(1100);
    }

       @Test
    public void noDiscountTest() {
        assertEquals(box.buyBird(duck1) + "", "" + 500.0);
    }
    @Test
    public void tenPesentDiscountTest() {
        assertEquals(box.buyBird(eagle1), 990.0, 0);
    }
    @Test
    public void fivePesentDiscountTest() {
        assertEquals(box.buyBird(duck2) + "", "57" + .0);
    }

}

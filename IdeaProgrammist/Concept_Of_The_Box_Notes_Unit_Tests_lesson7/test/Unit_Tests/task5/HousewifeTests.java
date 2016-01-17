package Unit_Tests.task5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Byblik272 on 16/1/2016.
 */
@RunWith(JUnit4.class)
public class HousewifeTests {

    Cat[] cats;
    Housewife housewife;

    @Before
    public void ini(){
        cats = new Cat[2];
        housewife = new Housewife();

        cats[0] = new Cat();
        cats[0].setName("Mikky1");

        cats[1] = new Cat();
        cats[1].setName("Mikky2");
    }

    @Test(expected = CatNotHangryException.class)
    public  void testFeedCats() {

        cats[1].setName("Mikky2");
        cats[1].setHungry(false);
        housewife.feed(cats);
        for(Cat cat : cats) {
            assertFalse(cat.isHungry());
        }
    }
}

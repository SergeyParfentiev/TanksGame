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
public class CatTests {

    Cat cat;

    @Before
    public void ini(){
        cat = new Cat();
    }

    @Test
    public void checkCatNameDefaultValue() {
       assertNull("Cat defailt name isn`t  ", cat.getName());
    }
    @Test
    public void checkCatWeightDefaultValue() {
        assertTrue("Cat weight name isn`t  ", cat.getWeight() == 0.0);
    }
    @Test
    public void checkCatIsHungryDefaultValue() {
       assertTrue("Cat should be hungry  ", cat.isHungry());
    }
    @Test
    public void checkCatSetName() {
        String name = "Mikky";
        cat.setName(name);
        assertEquals(name, cat.getName());
    }
}

package Unit_Tests.task6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

/**
 * Created by Byblik272 on 17/1/2016.
 */
@RunWith(JUnit4.class)
public class ServiceRepositoryTests {

    ServiceRepository sr;
    Cleaning cleaning;
    Painting painting;

    @Before
    public void init() {
        sr = new ServiceRepository();
        cleaning = new Cleaning();
 //       painting = new Painting();
    }

    @Test
    public void vipTestFirst() {
        assertTrue(sr.first.isVip());
    }
    @Test
    public void vipTestSecond() {
        assertFalse(sr.second.isVip());
    }
    @Test
    public void cleanTest() {
        assertFalse(cleaning.getService());
    }
    @Test
    public void checkInitialization() {
        assertNull(painting);
    }
}

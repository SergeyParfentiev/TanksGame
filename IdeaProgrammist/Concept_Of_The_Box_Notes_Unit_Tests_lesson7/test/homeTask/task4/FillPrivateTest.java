package homeTask.task4;

import Reflection.task5.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Byblik272 on 25/1/2016.
 */
@RunWith(JUnit4.class)
public class FillPrivateTest {

    Person person;
    FillPrivate fillPrivate;
    Map<String, Object> map;

    @Before
    public void init() {
        person = new Person();
        fillPrivate = new FillPrivate();
        map = new HashMap<>();
    }

    @Test
    public void setPrivatesCorrectFieldsTest() throws NoSuchFieldException, IllegalAccessException {
        map.put("name", "Vasya");
        map.put("age", 10);
        map.put("married", false);

        fillPrivate.setPrivates(person, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPrivatesWrongFieldsTest() throws NoSuchFieldException, IllegalAccessException {
        map.put("name", false);
        map.put("age", 10);
        map.put("married", "Vasya");

        fillPrivate.setPrivates(person, map);
    }

    @Test(expected = NoSuchFieldException.class)
    public void setPrivatesMissFieldsTest() throws NoSuchFieldException, IllegalAccessException {
        map.put("notName", "Handsome");
        map.put("age", 10);
        map.put("married", false);

        fillPrivate.setPrivates(person, map);
    }
}

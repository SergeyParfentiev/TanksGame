package homeTask.task3;

import Reflection.task4.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byblik272 on 25/1/2016.
 */
@RunWith(JUnit4.class)
public class FillTest {

    Fill<Bird> fill;
    List<Object> list;
    Bird bird;

    @Before
    public void init(){
        fill = new Fill();
    }

    @Test
    public void initClassDefaultTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        list = new ArrayList<>();
        bird = fill.initClass(Bird.class, list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void initClassWrongOptionsTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        list = new ArrayList<>();
        list.add("Options");
        list.add("not");
        list.add("correct!");
        bird = fill.initClass(Bird.class, list);
    }

    @Test
    public void initClassCorrectOptionsTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        list = new ArrayList<>();
        list.add("Ducky");
        list.add(10);
        list.add(50);
        bird = fill.initClass(Bird.class, list);
    }
}

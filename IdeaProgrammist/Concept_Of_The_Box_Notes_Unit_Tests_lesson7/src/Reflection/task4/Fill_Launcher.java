package Reflection.task4;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Byblik272 on 19/1/2016.
 */
public class Fill_Launcher {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        Fill<Bird> fill = new Fill<>();
        Bird bird;

        List<Object> list = new ArrayList<>();
        list.add("Ducky");
        list.add(10);
        list.add(50);

        bird = fill.initClass(Bird.class, list);

    }
}

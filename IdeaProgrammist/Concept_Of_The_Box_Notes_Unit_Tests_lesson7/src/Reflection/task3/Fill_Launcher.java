package Reflection.task3;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Byblik272 on 19/1/2016.
 */
public class Fill_Launcher {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        Fill<Bird> fill = new Fill<>();
        Bird bird;

        Map<String, Object> map = new HashMap<>();
        map.put("Name", "Duck");
        map.put("Count", 10);
        map.put("Cost", 30);

        bird = fill.initClass(Bird.class, map);

    }
}

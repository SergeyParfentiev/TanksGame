package Reflection.task5;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by Byblik272 on 20/1/2016.
 */
public class FillPrivate {

    public void setPrivates(Object object, Map<String, Object> map) throws NoSuchFieldException, IllegalAccessException {

        for(Map.Entry<String, Object> entry : map.entrySet()) {
            Field field = object.getClass().getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(object, entry.getValue());
        }
    }
}

package Reflection.task5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Byblik272 on 20/1/2016.
 */
public class FillPrivate_Launcher {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        FillPrivate fillPrivate = new FillPrivate();

        Person person = new Person();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Vasya");
        map.put("age", 10);
        map.put("married", false);

        fillPrivate.setPrivates(person, map);

        person.personInformation();
    }
}

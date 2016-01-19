package Reflection.task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Byblik272 on 18/1/2016.
 */
public class Fill<T> {

    public T initClass(Class<T> aClass, Map<String, Object> map) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T classObject = aClass.newInstance();

        for(Map.Entry<String, Object> entry : map.entrySet()) {
            for(Method method : aClass.getMethods()) {
                if(method.getName().contains("set" + entry.getKey())) {
                    method.invoke(classObject, entry.getValue());
                }
            }
        }
        return classObject;
    }
}

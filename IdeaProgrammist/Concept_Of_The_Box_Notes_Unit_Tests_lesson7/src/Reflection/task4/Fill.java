package Reflection.task4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Byblik272 on 19/1/2016.
 */
public class Fill<T> {

    public T initClass(Class<T> aClass, List<Object> list) throws InstantiationException, IllegalAccessException, InvocationTargetException {

        T objectClass;
        Constructor<T> tConstructor = null;

        for(Constructor constructor : aClass.getConstructors()) {
            if(constructor.getParameterTypes().length == list.size()) {
                tConstructor = constructor;
            }
        }
            objectClass = tConstructor.newInstance(list.toArray());
            return objectClass;
    }
}

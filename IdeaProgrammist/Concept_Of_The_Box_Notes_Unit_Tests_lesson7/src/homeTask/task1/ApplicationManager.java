package homeTask.task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Byblik272 on 21/1/2016.
 */

public class ApplicationManager {

    public <T> void checkPresentAnnotation(Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        int i = 0;
        if(clazz.isAnnotationPresent(Service.class)) {
            System.out.println("Annotation Sevice is present in " + clazz.getSimpleName());
            T classObject = clazz.newInstance();

            for (Method method : clazz.getMethods()) {
                if (method.getAnnotation(InitService.class) != null) {
                    System.out.print("Annotation InitService is present in ");
                    method.invoke(classObject);
                    i++;
                }
            }
            if(i == 0) {
                System.out.println("Annotation InitService isn`t present in " + clazz.getSimpleName() + "\n");
            }
        } else {
            System.out.println("Annotation Sevice isn`t present in " + clazz.getSimpleName() + "\n");
        }
    }

    public <T> T getService(Class<T> clazz) throws IllegalAccessException, InstantiationException {

        System.out.println(clazz.getSimpleName() + " created!\n");
        return clazz.newInstance();
    }
}

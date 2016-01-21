package Reflection.task7;

import java.lang.annotation.Annotation;

/**
 * Created by Byblik272 on 21/1/2016.
 */
public class ApplicationManager {

    public void checkPresentAnnotation(Class clazz) {

        Annotation an = clazz.getAnnotation(Service.class);
        if(clazz.isAnnotationPresent(Service.class)) {
            System.out.println("Annotation Sevice is present");
        } else {
            System.out.println("Annotation Sevice isn`t present");
        }
    }
}

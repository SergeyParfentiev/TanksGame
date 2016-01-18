package Reflection.task2;

import java.util.Arrays;

/**
 * Created by Byblik272 on 18/1/2016.
 */
public class Son extends Father{

    private int zero;
    static Class beforeClass;

    public void firstSonMetod() {
    }


   public static void printClassInfo(Class aClass) {
       beforeClass = aClass;
       while (true) {
           System.out.println(beforeClass.getName());
           System.out.println(beforeClass.getSimpleName());
           if (beforeClass.getSuperclass() != null) {
               beforeClass = beforeClass.getSuperclass();
           } else {
               break;
           }
       }
       System.out.println();
   }

    public static void printClassMetods(Class aClass) {
        beforeClass = aClass;
        while (true) {
            System.out.println(Arrays.toString(beforeClass.getMethods()));
            System.out.println(Arrays.toString(beforeClass.getConstructors()));
            if (beforeClass.getSuperclass() != null) {
                beforeClass = beforeClass.getSuperclass();
            } else {
                break;
            }
        }
        System.out.println();
    }
    public static void printClassFields(Class aClass) {
        beforeClass = aClass;
        while (true) {
            System.out.println(Arrays.toString(beforeClass.getDeclaredFields()));
            if (beforeClass.getSuperclass() != null) {
                beforeClass = beforeClass.getSuperclass();
            } else {
                break;
            }
        }
        System.out.println();
    }
}

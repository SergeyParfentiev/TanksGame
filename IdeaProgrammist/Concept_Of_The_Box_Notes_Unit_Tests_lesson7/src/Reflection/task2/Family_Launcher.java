package Reflection.task2;

/**
 * Created by Byblik272 on 18/1/2016.
 */
public class Family_Launcher {
    public static void main(String[] args) {

        Class aClass = Son.class;

        Son.printClassInfo(aClass);
        Son.printClassMetods(aClass);
        Son.printClassFields(aClass);
    }
}

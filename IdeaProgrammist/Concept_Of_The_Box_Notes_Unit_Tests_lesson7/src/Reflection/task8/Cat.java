package Reflection.task8;

/**
 * Created by Byblik272 on 21/1/2016.
 */
public class Cat {

    @InitService
    public void name() {
        System.out.println(this.getClass().getSimpleName());
    }
}

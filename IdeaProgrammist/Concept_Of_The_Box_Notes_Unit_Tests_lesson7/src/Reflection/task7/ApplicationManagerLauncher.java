package Reflection.task7;

/**
 * Created by Byblik272 on 21/1/2016.
 */
public class ApplicationManagerLauncher {
    public static void main(String[] args) {

        ApplicationManager am = new ApplicationManager();

        am.checkPresentAnnotation(Bird.class);
        am.checkPresentAnnotation(Cat.class);
    }
}

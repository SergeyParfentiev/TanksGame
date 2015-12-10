package task2;

/**
 * Created by Byblik272 on 19/11/2015.
 */
import java.awt.*;

public abstract class AbstractShape implements Drawable{

    protected int x;
    protected int y;
    protected int h;
    protected int v;
    protected Color color;

    public Color getColor() {
        return color;
    }


    public void iAm() {
        System.out.println("I am is: " + getClass().getSimpleName());
    }
}

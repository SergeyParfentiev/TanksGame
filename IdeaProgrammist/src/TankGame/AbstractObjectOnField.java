package TankGame;

import java.awt.*;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public abstract class AbstractObjectOnField implements Drawable{

    private int x;
    private int y;

    public AbstractObjectOnField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

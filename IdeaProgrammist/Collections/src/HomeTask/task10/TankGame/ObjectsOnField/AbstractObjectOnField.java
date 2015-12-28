package HomeTask.task10.TankGame.ObjectsOnField;

import HomeTask.task10.TankGame.Tanks.Drawable;
import HomeTask.task10.TankGame.Tanks.Destroyable;

import java.awt.*;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public abstract class AbstractObjectOnField implements Drawable, Destroyable {

    private int x;
    private int y;

    private boolean isDestroyed = false;
    protected Color color;

    public AbstractObjectOnField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void destroy() {
        isDestroyed = true;
    }

    @Override
    public void draw(Graphics g) {
        if (!isDestroyed) {
            g.setColor(this.color);
            g.fillRect(this.getX(), this.getY(), 64, 64);
        }
    }

    public boolean isDestroyed() {
        return isDestroyed;
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

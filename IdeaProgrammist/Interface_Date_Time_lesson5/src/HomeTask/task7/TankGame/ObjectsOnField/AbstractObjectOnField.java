package HomeTask.task7.TankGame.ObjectsOnField;

import HomeTask.task7.TankGame.Tanks.Destroyable;
import HomeTask.task7.TankGame.Tanks.Drawable;

import java.awt.*;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public abstract class AbstractObjectOnField implements Drawable, Destroyable {

    private int x;
    private int y;

    private boolean isDestroyed = false;
    protected Color color;
    protected Image image;
    protected Image water;

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
        Graphics2D g2 = (Graphics2D)g;
        if (!isDestroyed) {
            if(image != null) {

                g.drawImage(image, getX(), getY(), getX() + 64, getY() + 64, getX(), getY(), getX() + 64, getY() + 64, null);

            } else {
                Composite first = g2.getComposite();
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
                g2.drawImage(water, getX(), getY(), getX() + 64, getY() + 64, getX(), getY(), getX() + 64, getY() + 64, null);
                g2.setComposite(first);

                if(image == null && water == null) {
                g.setColor(this.color);
                g.fillRect(this.getX(), this.getY(), 64, 64);
                }
            }
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

package HomeTask.task10.TankGame.Tanks;

import java.awt.*;

/**
 * Created by Byblik272 on 18/11/2015.
 */

public class Bullet implements Drawable, Destroyable {

    private int x;
    private int y;

    private int Speed = 5;

    private Direction direction;
    private boolean destroyed;

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;
    }

    public Direction getDirection() {
        return direction;
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

    public int getSpeed() {
        return Speed;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    public void destroy() {
        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public void draw(Graphics g) {
        if(!destroyed) {
            g.setColor(new Color(255, 255, 0));
            g.fillRect(this.getX(), this.getY(), 14, 14);
        }
    }



}


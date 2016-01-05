package HomeTask.task7.TankGame.Tanks;

import HomeTask.task7.TankGame.ObjectsOnField.BattleField;
import HomeTask.task7.TankGame.ObjectsOnField.Water;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 18/11/2015.
 */

public class Bullet implements Drawable, Destroyable {

    private int x;
    private int y;

    private int Speed = 5;

    private Direction direction;
    private boolean destroyed;
    Tank tank;

    Image[] images;

    public Bullet(int x, int y, Direction direction, Tank tank) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;
        this.tank = tank;
        setImage();
    }
    public Tank getTank() {
        return tank;
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

    private void setImage() {
        images = new Image[4];
        try {
            images[0] = ImageIO.read(new File("Bullet_UP.png").getAbsoluteFile());
            images[1] = ImageIO.read(new File("Bullet_DOWN.png").getAbsoluteFile());
            images[2] = ImageIO.read(new File("Bullet_LEFT.png").getAbsoluteFile());
            images[3] = ImageIO.read(new File("Bullet_RIGHT.png").getAbsoluteFile());
        }catch (IOException e) {
            throw new IllegalStateException("Can`t find tank image");
        }
    }

    @Override
    public void draw(Graphics g) {
        if(!destroyed) {
            if(images != null) {
                g.drawImage(images[getDirection().getId()], getX(), getY(), null);
            } else {
                g.setColor(new Color(255, 255, 0));
                g.fillRect(this.getX(), this.getY(), 14, 14);
            }
        }
    }



}


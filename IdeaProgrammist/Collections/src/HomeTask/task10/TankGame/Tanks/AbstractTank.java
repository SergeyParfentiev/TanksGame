package HomeTask.task10.TankGame.Tanks;
import HomeTask.task10.TankGame.Action.ActionField;
import HomeTask.task10.TankGame.ObjectsOnField.BattleField;

import java.awt.*;
import java.util.Random;

/**
 * Created by Byblik272 on 18/11/2015.
 */
public abstract class AbstractTank implements Tank {


    protected int speed = 7;
    protected int movePath = 1;

    protected int x;
    protected int y;

    protected Color tankColor;
    protected Color towerColor;

    private boolean destroyed;

    protected Direction direction;

    BattleField bf;



    public AbstractTank(BattleField bf) {
        this(bf, 128, 512, Direction.UP);
    }

    public AbstractTank(BattleField bf, int x, int y, Direction direction) {
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;
    }


    public void turn(Direction direction) {
        this.direction = direction;
    }

    public void move() {

    }

    public Bullet fire() {
        int bulletX = -100;
        int bulletY = -100;
        if (direction == Direction.UP) {
            bulletX = x + 25;
            bulletY = y - 14;
        } else if (direction == Direction.DOWN) {
            bulletX = x + 25;
            bulletY = y + 74;
        } else if (direction == Direction.LEFT) {
            bulletX = x - 14;
            bulletY = y + 25;
        } else if (direction == Direction.RIGHT) {
            bulletX = x + 74;
            bulletY = y + 25;
        }
        return new Bullet(bulletX, bulletY, direction);

    }

    public void moveToQuadrant(int v, int h) throws Exception {
        String coordinates = ActionField.getQuadrantXY(v, h);
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));

        if (this.x < x) {
            while (this.x != x) {
                turn(Direction.RIGHT);

                move();
            }
        } else {
            while (this.x != x) {
                turn(Direction.LEFT);

                move();
            }
        }

        if (this.y < y) {
            while (this.y != y) {
                turn(Direction.DOWN);

                move();
            }
        } else {
            while (this.y != y) {
                turn(Direction.UP);

                move();
            }
        }
    }

    public void moveRandom() throws Exception {
        Random r = new Random();
        int i;
        while (true) {
            i = r.nextInt(4) + 1;
            turn(Direction.values()[i]);

            move();

        }
    }

    public void clean(int v, int h) throws Exception {

    }
    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        destroyed = true;
    }


    public Direction getDirection() {
        return direction;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
    @Override
    public int getMovePath() {
        return movePath;
    }

    @Override
    public void draw(Graphics g) {
        if (!destroyed) {
            g.setColor(tankColor);
            g.fillRect(this.getX(), this.getY(), 64, 64);

            g.setColor(towerColor);
            if (this.getDirection() == Direction.UP) {
                g.fillRect(this.getX() + 20, this.getY(), 24, 34);

            } else if (this.getDirection() == Direction.DOWN) {
                g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);

            } else if (this.getDirection() == Direction.LEFT) {
                g.fillRect(this.getX(), this.getY() + 20, 34, 24);

            } else {
                g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
            }
        }
    }
}

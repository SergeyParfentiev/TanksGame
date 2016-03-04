package HomeTask.task2.tanks;

import HomeTask.task2.action.ActionField;
import HomeTask.task2.objectsOnField.BattleField;
import HomeTask.task2.objectsOnField.Water;
import HomeTask.task2.objectsOnField.Space;

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
    protected Image[] images;

    BattleField bf;
    Tank tank;

    protected int arrayIdx = 0;
    Action action;


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

    Object[] actions;

    private void action() {
    actions = new Object[] {
            Direction.UP,
            Action.FIRE,
            Action.MOVE,
            Action.FIRE,
            Action.MOVE,
            Action.FIRE,
            Action.MOVE,
            Action.MOVE,
            Action.FIRE,
            Direction.RIGHT,
            Action.MOVE,
            Action.FIRE,
            Action.FIRE,
            Action.FIRE
    }

    ;
}
    public void destroyOpponent(Tank opponent, BattleField bf){

        tank = opponent;
        if(getX() == opponent.getX() && getY() > opponent.getY()) {
            turn(Direction.UP);
            action = Action.FIRE;
        }
        if(getX() == opponent.getX() && getY() < opponent.getY()) {
            turn(Direction.DOWN);
            action = Action.FIRE;
        }if(getX() > opponent.getX() && getY() == opponent.getY()) {
            turn(Direction.LEFT);
            action = Action.FIRE;
        }
        if(getX() < opponent.getX() && getY() == opponent.getY()) {
            turn(Direction.RIGHT);
            action = Action.FIRE;
        }
        if(Math.abs(getX() - opponent.getX()) < Math.abs(getY() - opponent.getY())) {
            if(getX() > opponent.getX()) {
                turn(Direction.LEFT);
                if(!(bf.scanQuadrant(getY() /bf.getLimitQadrant(), (getX() / bf.getLimitQadrant() - 1)) instanceof Water) &&
                        !(bf.scanQuadrant(getY() /bf.getLimitQadrant(), (getX() / bf.getLimitQadrant() - 1)) instanceof Space)
                        && !bf.scanQuadrant(getY() / bf.getLimitQadrant(), (getX() / bf.getLimitQadrant() - 1)).isDestroyed()) {
                    action = Action.FIRE;
                } else {
                    action = Action.MOVE;
                }
            }
            if(getX() < opponent.getX()) {
                turn(Direction.RIGHT);
                if(!(bf.scanQuadrant(getY() / bf.getLimitQadrant(), (getX() / bf.getLimitQadrant() + 1)) instanceof Water) &&
                        !(bf.scanQuadrant(getY() / bf.getLimitQadrant(), (getX() / bf.getLimitQadrant() + 1)) instanceof Space)
                        && !bf.scanQuadrant(getY() / bf.getLimitQadrant(), (getX() / bf.getLimitQadrant() +1)).isDestroyed()) {
                    action = Action.FIRE;
                } else {
                    action = Action.MOVE;
                }
            }
        }else {
            if(getY() > opponent.getY()) {
                turn(Direction.UP);
                if(!(bf.scanQuadrant((getY() / bf.getLimitQadrant() - 1), getX() / bf.getLimitQadrant()) instanceof Water) &&
                        !(bf.scanQuadrant((getY() / bf.getLimitQadrant() - 1),getX() / bf.getLimitQadrant()) instanceof Space)
                        && !bf.scanQuadrant((getY() / bf.getLimitQadrant() - 1),getX() / bf.getLimitQadrant()).isDestroyed()) {
                    action = Action.FIRE;
                } else {
                    action = Action.MOVE;
                }
            }
            if(getY() < opponent.getY()) {
                turn(Direction.DOWN);
                if(!(bf.scanQuadrant((getY() / bf.getLimitQadrant() + 1),getX() / bf.getLimitQadrant()) instanceof Water) &&
                        !(bf.scanQuadrant((getY() / bf.getLimitQadrant() + 1),getX() / bf.getLimitQadrant()) instanceof Space)
                        && !bf.scanQuadrant((getY() / bf.getLimitQadrant() + 1),getX() / bf.getLimitQadrant()).isDestroyed()) {
                    action = Action.FIRE;
                } else {
                    action = Action.MOVE;
                }
            }
        }

    }
    protected Action getAction() {
        if(tank == null) {
           action();
            if (arrayIdx >= actions.length) {
                arrayIdx = 0;
            }
            if (!(actions[arrayIdx] instanceof Action)) {
                turn((Direction) actions[arrayIdx++]);
            }
            return (Action) actions[arrayIdx++];
        }else {

//            if (arrayIdx >= actions.length) {
//                arrayIdx = 0;
//            }
//            if (!(actions[arrayIdx] instanceof action)) {
//                turn((Direction) actions[arrayIdx++]);
//            }
//            action = (action) actions[arrayIdx++];
            tank = null;
            return action;
        }
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
        return new Bullet(bulletX, bulletY, direction, this);

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

    @Override
    public void create() {
        destroyed = false;
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

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
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
            if(images != null) {
                Graphics2D g2 = (Graphics2D)g;
                Composite first = g2.getComposite();
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                g.drawImage(images[getDirection().getId()], getX(), getY(), null);
                g2.setComposite(first);
                if(bf.scanQuadrant(getY() / bf.getLimitQadrant(), getX() / bf.getLimitQadrant()) instanceof Water) {
                    bf.scanQuadrant(getY() / bf.getLimitQadrant(), getX() / bf.getLimitQadrant()).draw(g);
                }

            }else {
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
                if(bf.scanQuadrant(getY() / 64, getX() / 64) instanceof Water) {
                    bf.scanQuadrant(getY() / 64, getX() / 64).draw(g);
                }
            }
        }
    }
}

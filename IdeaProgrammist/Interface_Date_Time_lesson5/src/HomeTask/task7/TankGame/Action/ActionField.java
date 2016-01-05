package HomeTask.task7.TankGame.Action;

import HomeTask.task7.TankGame.ObjectsOnField.*;
import HomeTask.task7.TankGame.Tanks.Action;
import HomeTask.task7.TankGame.Tanks.*;

import javax.swing.*;
import java.awt.*;

public class ActionField extends JPanel {

//    private static final long serialVersionUID = 1L;


    private static BattleField battleField;
    private Tank defender;
    private Tank aggressor;
    private Bullet bullet;
    boolean play = true;
    private int nextQuadrant;

    public void runTheGame() throws Exception {

        AbstractObjectOnField eagle = battleField.getEagleLocation();
        while(play == true) {
            aggressor.agressorDestroyDefender(defender, battleField);
            if (!aggressor.isDestroyed() && !defender.isDestroyed() && !eagle.isDestroyed()) {
                processAction(aggressor.setUp(), aggressor);
            }
            if (!aggressor.isDestroyed() && !defender.isDestroyed() && !eagle.isDestroyed()) {
                processAction(defender.setUp(), defender);
            }
            if(!(!aggressor.isDestroyed() && !defender.isDestroyed() && !eagle.isDestroyed())) {
                play = false;
            }
        }
    }

    private void processAction(Action a, Tank t) throws Exception {
        if (a == Action.MOVE) {
            processMove(t);
           nextQuadrant = checkNextQuadrant(t.getDirection(), t, t.getY() / battleField.getLimitQadrant(), t.getX() / battleField.getLimitQadrant());
        } else if (a == Action.FIRE) {
            processTurn(t);
            processFire(t.fire());
        }
    }

    public void processTurn(Tank tank) throws Exception {
        repaint();
    }

    public void processMove(Tank tank) throws Exception {
        processTurn(tank);
        Direction direction = tank.getDirection();

        String tankQuadrant = getQuadrant(tank.getX(), tank.getY());
        int v = Integer.parseInt(tankQuadrant.split("_")[0]);
        int h = Integer.parseInt(tankQuadrant.split("_")[1]);

        if (checkLimits(tank.getDirection(), tank) == 0) {
            return;
        }
        if(checkNextQuadrant(tank.getDirection(), tank, v, h) == 0) {
            return;
        }


        int i = 0;
        int step = 1;
        while (i < battleField.getLimitQadrant()) {
            if (direction == Direction.UP) {
                tank.updateY(-step);
            }
            if (direction == Direction.DOWN) {
                tank.updateY(step);
            }
            if (direction == Direction.LEFT) {
                tank.updateX(-step);
            }
            if (direction == Direction.RIGHT) {
                tank.updateX(step);
            }

            i += step;

            repaint();
            Thread.sleep(tank.getSpeed());
        }
    }
    private int checkLimits(Direction direction, Tank tank) {
        if ((direction == Direction.UP && tank.getY() == battleField.getMinRiftField())
                || (direction == Direction.DOWN && tank.getY() >= battleField.getMaxRiftField())
                || (direction == Direction.LEFT && tank.getX() == battleField.getMinRiftField())
                || (direction == Direction.RIGHT && tank.getX() >= battleField.getMaxRiftField())) {
            System.out.println("[illegal move] direction: " + direction
                    + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            return 0;
        } else return 1;
    }

    private int checkNextQuadrant(Direction direction, Tank tank, int v, int h) {
        if (direction == Direction.UP) {
            v--;
        } else if (direction == Direction.DOWN) {
            v++;
        } else if (direction == Direction.RIGHT) {
            h++;
        } else if (direction == Direction.LEFT) {
            h--;
        }
        AbstractObjectOnField abstractObjectOnField = battleField.scanQuadrant(v, h);
        if (!(abstractObjectOnField instanceof Space) &&!(abstractObjectOnField instanceof Water) && !abstractObjectOnField.isDestroyed() &&
                (true)) {
            System.out.println("[illegal move] direction: " + direction
                    + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            return 0;
        }else return 1;
    }

    public void processFire(Bullet bullet) throws Exception {
        this.bullet = bullet;
        int step = 1;
        while (bullet.getX() < 590 && bullet.getX() > -14 &&
                bullet.getY() < 590 && bullet.getY() > -14) {
            if (bullet.getDirection() == Direction.UP) {
                bullet.updateY(-step);
            } else if (bullet.getDirection() == Direction.DOWN) {
                bullet.updateY(step);

            } else if (bullet.getDirection() == Direction.LEFT) {
                bullet.updateX(-step);

            } else {
                bullet.updateX(step);
            }
            processInterception();
            repaint();
            Thread.sleep(bullet.getSpeed());
            if (bullet.isDestroyed()) {
                break;
            }
        }
    }

    private boolean processInterception() throws Exception {
        String coordinates = getQuadrant(bullet.getX(), bullet.getY());
        int y = Integer.parseInt(coordinates.split("_")[0]);
        int x = Integer.parseInt(coordinates.split("_")[1]);


        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            AbstractObjectOnField abstractObjectOnField = battleField.scanQuadrant(y, x);
            if(bullet.getTank() instanceof Tiger) {
                if (!abstractObjectOnField.isDestroyed() && !(abstractObjectOnField instanceof Space) && !(abstractObjectOnField instanceof Water)) {
                    battleField.destroyObject(y, x);
                    bullet.destroy();
                    return true;
                }
            }else  {
                if (!abstractObjectOnField.isDestroyed() && !(abstractObjectOnField instanceof Space) && !(abstractObjectOnField instanceof Water)) {
                    if(abstractObjectOnField instanceof Rock) {
                        bullet.destroy();
                        return true;
                    }else {
                        battleField.destroyObject(y, x);
                        bullet.destroy();
                        return true;
                    }
                }
            }
        }
        if (!aggressor.isDestroyed() && checkInterception(getQuadrant(aggressor.getX(), aggressor.getY()), coordinates)) {
            aggressor.destroy();
            bullet.destroy();
            return true;
        }


        if (!defender.isDestroyed() && checkInterception(getQuadrant(defender.getX(), defender.getY()), coordinates)) {
            defender.destroy();
            bullet.destroy();
            return true;
        }
        return false;
    }

    private boolean checkInterception(String object, String quadrant) {
        int oy = Integer.parseInt(object.split("_")[0]);
        int ox = Integer.parseInt(object.split("_")[1]);

        int qy = Integer.parseInt(quadrant.split("_")[0]);
        int qx = Integer.parseInt(quadrant.split("_")[1]);

        if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
            if (oy == qy && ox == qx) {
                return true;
            }
        }
        return false;
    }

    String getQuadrant(int x, int y) {
        return y / battleField.getLimitQadrant() + "_" + x / battleField.getLimitQadrant();
    }

    public static String getQuadrantXY(int v, int h) {
        return (v - 1) * battleField.getLimitQadrant() + "_" + (h - 1) * battleField.getLimitQadrant();
    }

    public ActionField() throws Exception {

        battleField = new BattleField();
        defender = new T34(battleField);

        String location = battleField.getAggressorLocation();
        aggressor = new Tiger(battleField,
                Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.RIGHT);
        bullet = new Bullet(-100, -100, Direction.UP, defender);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH(), battleField.getBF_HEIGHT()));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            battleField.draw(g);
            defender.draw(g);
            aggressor.draw(g);
            bullet.draw(g);
    }


}
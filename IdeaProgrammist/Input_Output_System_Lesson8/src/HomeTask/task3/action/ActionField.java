package HomeTask.task3.action;

import HomeTask.task3.gameRecord.RecordTankActions;
import HomeTask.task3.objectsOnField.*;
import HomeTask.task3.tanks.Action;
import HomeTask.task3.tanks.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ActionField //extends JPanel
{

//    private static final long serialVersionUID = 1L;


    private static BattleField battleField;
    private Tank defender;
    private Tank aggressor;
    private Bullet bullet;
    boolean play = false;
    private JPanel jTankChoose;
    private JFrame frame;
    private int tankIdx = 0;
    String location;
    int locationX;
    int locationY;
    boolean choose = false;
    boolean replayGame = false;
    private AbstractObjectOnField eagle;
    JPanel gameOver;
    String fileName = "/GameRecord.txt";
    private RecordTankActions recordActions;
    private List recordList;

    public void runTheGame() throws Exception {
        while (true) {
               System.out.println();
            while (play) {
                if (!aggressor.isDestroyed() && !defender.isDestroyed() && !eagle.isDestroyed()) {
                    aggressor.destroyOpponent(defender, battleField);
                    processAction(aggressor.setUp(), aggressor);
                }
                if (!aggressor.isDestroyed() && !defender.isDestroyed() && !eagle.isDestroyed()) {
                    defender.destroyOpponent(aggressor, battleField);
                    processAction(defender.setUp(), defender);
                }
                if (!(!aggressor.isDestroyed() && !defender.isDestroyed() && !eagle.isDestroyed())) {
                    recordList = new ArrayList();
                    recordList = recordActions.read(fileName);
                    choose = true;
                    play = false;
                }
            }
            if(choose) {
                closeOrRepeat();
                choose = false;
            }
            if(replayGame) {
                for(int i = 0; i < recordList.size();) {
                    aggressor.turn((Direction) recordList.get(i++));
                    processAction((Action) recordList.get(i++), aggressor);
                    if(i < recordList.size()) {
                        defender.turn((Direction) recordList.get(i++));
                        processAction((Action) recordList.get(i++), defender);
                    } else {
                        break;
                    }
                }
                replayGame = false;
                choose = true;
            }
        }
    }

    private void processAction(Action a, Tank t) throws Exception {
        if (a == Action.MOVE) {
            processMove(t);
        } else if (a == Action.FIRE) {
            processTurn(t);
            processFire(t.fire());
        }
        if(!replayGame) {
            recordActions.write(t.getDirection(), a, fileName);
        }
    }

    public void processTurn(Tank tank) throws Exception {
        frame.repaint();
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
            frame.repaint();
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
            frame.repaint();
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
//        defender = new T34(battleField);
//        aggressor = new Tiger(battleField,
//                Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.RIGHT);
        bullet = new Bullet(-100, -100, Direction.UP, defender);

        frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(500, 150);
        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH(), battleField.getBF_HEIGHT()));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(gameOptions());
        frame.pack();
        frame.setVisible(true);
    }

    JPanel jGame = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            battleField.draw(g);
            defender.draw(g);
            aggressor.draw(g);
            bullet.draw(g);
        }
    };

    private JPanel gameOver() {
        gameOver = new JPanel();
        gameOver.setLayout(new GridBagLayout());
        JLabel resultGame;
        if(defender.isDestroyed() || eagle.isDestroyed()) {
            resultGame = new JLabel("You are Defeat!");
        } else {
            resultGame = new JLabel("You are Win!");
        }
        JButton goAgain = new JButton("Play Again");
        goAgain.setForeground(Color.BLACK);
        goAgain.setBackground(new Color(100, 255, 100));

        final JButton record = new JButton("Show the game record");
        record.setForeground(Color.BLACK);
        record.setBackground(new Color(100, 255, 100));

        JButton goOut = new JButton("Exit");
        goOut.setForeground(Color.BLACK);
        goOut.setBackground(new Color(100, 255, 100));

        gameOver.add(resultGame);
        gameOver.add(goAgain);
        gameOver.add(record);
        gameOver.add(goOut);

        goAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameResult();
            }
        });
        record.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRecord();
                drawBF();
                replayGame = true;
            }
        });
        goOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });

        return gameOver;
    }
private void createRecord() {
    battleField = new BattleField();
    aggressor.setX(locationX);
    aggressor.setY(locationY);
    aggressor.create();
    defender = new T34(battleField);

}

private JPanel gameOptions() {
    tankIdx = 0;
    jTankChoose = new JPanel();
    jTankChoose.setLayout(new GridBagLayout());
    JLabel lTank = new JLabel("Choose Aggressor Tank : ");

    ButtonGroup buttonGroup = new ButtonGroup();
    JPanel pTanks = new JPanel();
    ActionListener rbListener = new RBListener();
    String[] tanks = {"T34", "BT7", "Tiger"};
    for(int i = 0; i < tanks.length; i++) {
        JRadioButton radioButton = new JRadioButton(tanks[i]);
        radioButton.setActionCommand(String.valueOf(i));
        radioButton.addActionListener(rbListener);
        if(i == 0) {
            radioButton.setSelected(true);
        }
        buttonGroup.add(radioButton);
        pTanks.add(radioButton);
    }
    pTanks.setLayout(new GridLayout(tanks.length / 2, 0, 0, 0));
    pTanks.setBorder(BorderFactory.createLineBorder(Color.GREEN));

    JButton goGame = new JButton("Go Game");
    goGame.setForeground(Color.BLACK);
    goGame.setBackground(new Color(100, 255, 100));

    jTankChoose.add(lTank, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jTankChoose.add(pTanks, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
    jTankChoose.add(goGame, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(50, -30, 0, 0), 0, 0));

    goGame.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectTank();
            drawBF();
            play = true;
            recordActions = new RecordTankActions();
        }
    });

    return jTankChoose;
}
    private void selectTank() {
        battleField = new BattleField();
        eagle = battleField.getEagleLocation();
        location = battleField.getAggressorLocation();
        locationX = Integer.parseInt(location.split("_")[1]);
        locationY = Integer.parseInt(location.split("_")[0]);
        if(tankIdx == 0) {
            aggressor = new T34(battleField,
                    locationX, locationY, Direction.RIGHT);
        } else if(tankIdx == 1) {
            aggressor = new BT7(battleField,
                    locationX, locationY, Direction.RIGHT);
        } else if(tankIdx == 2) {
            aggressor = new Tiger(battleField,
                    locationX, locationY, Direction.RIGHT);
        }
        defender = new T34(battleField);

    }
    private void drawBF(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(jGame);

        frame.pack();
        frame.repaint();
    }

    private void closeOrRepeat() {
        frame.getContentPane().removeAll();
        gameOver();
        frame.getContentPane().add(gameOver);

        frame.pack();
        frame.repaint();
    }
    private void gameResult() {
        frame.getContentPane().removeAll();
        gameOptions();
        frame.getContentPane().add(jTankChoose);

        frame.pack();
        frame.repaint();

    }
    private class RBListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tankIdx = Integer.parseInt(e.getActionCommand());
        }
    }

}
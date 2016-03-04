package HomeTask.task2.objectsOnField;

import HomeTask.task2.tanks.Drawable;

import java.awt.*;

/**
 * Created by Byblik272 on 18/11/2015.
 */

public class BattleField implements Drawable {

    final boolean COLORDED_MODE = false;

    private final int BF_WIDTH = 576 + 16;
    private final int BF_HEIGHT = 576 + 39;

    private final int limitQadrant = 64;

    private final int minRiftField = 0;
    private final int maxRiftField = 512;

    public static final String BRICK = "B";
    public static final String EAGLE = "E";
    public static final String ROCK = "R";
    public static final String WATER = "W";
    public static final String SPACE = " ";

    private int EagleV;
    private int EagleH;


    private String[][] battleField = {
            {"B", "B", "R", "B", "R", "W", "W", " ", " "},
            {" ", "B", "W", " ", " ", "B", "W", "W", "W"},
            {" ", "B", "R", "W", "B", "B", "R", "B", "W"},
            {" ", "R", " ", " ", " ", "R", " ", " ", " "},
            {" ", "B", "B", " ", " ", "B", "B", " ", "B"},
            {"B", "R", "B", "B", " ", " ", " ", " ", "B"},
            {"B", "B", "W", "B", " ", " ", " ", " ", " "},
            {"R", "B", "W", "B", " ", "R", " ", " ", "B"},
            {" ", "B", " ", "B", "E", "B", " ", "B", "B"}};

    public BattleField() {
        addObjectField();
    }

    private AbstractObjectOnField[][] objectOnFields = new AbstractObjectOnField[battleField.length][battleField[0].length];

        public void addObjectField() {

            for (int v = 0; v < battleField.length; v++) {
                for (int h = 0; h < battleField[0].length; h++) {

                    String obj = battleField[v][h];
                    if (obj.equals(SPACE)) {
                        objectOnFields[v][h] = new Space(h * limitQadrant, v * limitQadrant);
                    }
                    if (obj.equals(BRICK)) {
                        objectOnFields[v][h] = new Brick(h * limitQadrant, v * limitQadrant);
                    }
                    if (obj.equals(ROCK)) {
                        objectOnFields[v][h] = new Rock(h * limitQadrant, v * limitQadrant);
                    }
                    if (obj.equals(WATER)) {
                        objectOnFields[v][h] = new Water(h * limitQadrant, v * limitQadrant);
                    }
                    if (obj.equals(EAGLE)) {
                        objectOnFields[v][h] = new Eagle(h * limitQadrant, v * limitQadrant);
                        EagleV = v;
                        EagleH = h;
                    }
                }
            }
        }
    public String getEagleLocationSt() {

        return EagleV + " " + EagleH;
    }

    public AbstractObjectOnField  getEagleLocation() {
        return objectOnFields[EagleV][EagleH];
    }

    public String getAggressorLocation() {
        return "512_0";
    }

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

    public int getLimitQadrant() {
        return limitQadrant;
    }

    public int getMinRiftField() {
        return minRiftField;
    }

    public int getMaxRiftField() {
        return maxRiftField;
    }

    public AbstractObjectOnField scanQuadrant(int v, int h) {
        return objectOnFields[v][h];
    }

    public void destroyObject(int v, int h) {
        objectOnFields[v][h].destroy();
    }

    @Override
    public void draw(Graphics g) {
        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(0, 0, 0);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

            for (int v = 0; v < battleField.length; v++) {
                for (int h = 0; h < battleField[0].length; h++) {
                    objectOnFields[v][h].draw(g);
            }
        }
    }

}
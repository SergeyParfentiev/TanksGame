package TankGame.ObjectsOnField;

import TankGame.Tanks.Drawable;

import java.awt.*;

/**
 * Created by Byblik272 on 18/11/2015.
 */

public class BattleField implements Drawable {

    final boolean COLORDED_MODE = false;

    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    private final int limitQadrant = 64;

    private final int minRiftField = 0;
    private final int maxRiftField = 512;


    private String[][] battleField = {
            {"B", "B", "B", "B", " ", "B", "B", " ", " "},
            {"B", "W", "W", " ", " ", "B", "W", "W", "W"},
            {" ", "B", "R", "W", "B", "B", "R", "B", "W"},
            {" ", "R", " ", " ", " ", " ", " ", "R", " "},
            {" ", " ", "B", " ", " ", "B", "B", "R", "B"},
            {"B", "R", "B", "B", " ", " ", " ", "B", "B"},
            {"B", "B", "W", " ", " ", " ", " ", "B", " "},
            {" ", "B", "W", "B", " ", "B", "B", " ", "B"},
            {"B", "B", " ", "E", " ", "B", " ", "B", "B"}};

    private AbstractObjectOnField[][] objectOnFields = new AbstractObjectOnField[battleField.length][battleField[0].length];

        public void addObjectField() {

            for (int v = 0; v < battleField.length; v++) {
                for (int h = 0; h < battleField[0].length; h++) {
                    if (battleField[v][h] == " ") {
                        objectOnFields[v][h] = new Space(h * limitQadrant, v * limitQadrant);
                    }
                    if (battleField[v][h] == "B") {
                        objectOnFields[v][h] = new Brick(h * limitQadrant, v * limitQadrant);
                    }
                    if (battleField[v][h] == "R") {
                        objectOnFields[v][h] = new Rock(h * limitQadrant, v * limitQadrant);
                    }
                    if (battleField[v][h] == "W") {
                        objectOnFields[v][h] = new Water(h * limitQadrant, v * limitQadrant);
                    }
                    if (battleField[v][h] == "E") {
                        objectOnFields[v][h] = new Eagle(h * limitQadrant, v * limitQadrant);

                    }
                }
            }
        }


    public String[][] getBattleField() {
        return battleField;
    }

    public void getAggressorLocation() {

    }

    public void setBattleField(String[][] battleField) {
        this.battleField = battleField;
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

    public void updateQuadrant(int v, int h) {
        objectOnFields[v][h] = new Space(h * limitQadrant, v * limitQadrant);
    }

    public int getDimentionX() {
        return battleField[0].length;
    }

    public int getDimentionY() {
        return battleField.length;
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
                    cc = new Color(180, 180, 180);
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
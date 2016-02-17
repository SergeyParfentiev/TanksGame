package HomeTask.task3.tanks;


import HomeTask.task3.objectsOnField.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 18/11/2015.
 */
public class T34 extends AbstractTank {

    public T34(BattleField bf) {
        super(bf, 448, 256, Direction.UP);
        tankColor = new Color(0, 255, 0);
        towerColor = new Color(255, 0, 0);
        setImage();
    }

    public T34(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(0, 255, 0);
        towerColor = new Color(255, 0, 0);
        setImage();
    }

    private void setImage() {
        images = new Image[4];
        try {
            images[0] = ImageIO.read(new File("T34_UP.png").getAbsoluteFile());
            images[1] = ImageIO.read(new File("T34_DOWN.png").getAbsoluteFile());
            images[2] = ImageIO.read(new File("T34_LEFT.png").getAbsoluteFile());
            images[3] = ImageIO.read(new File("T34_RIGHT.png").getAbsoluteFile());
        }catch (IOException e) {
            throw new IllegalStateException("Can`t find tank image");
        }
    }

    private Object[] actions = new Object[] {
            Direction.RIGHT,
            Action.FIRE,
            Action.MOVE,
            Action.FIRE,
            Action.MOVE,
            Action.FIRE,
            Action.FIRE
    };

    private int step = 0;

    @Override
    public Action setUp() {
        if (step >= actions.length) {
            step = 0;
        }
        if (!(actions[step] instanceof Action)) {
            turn((Direction) actions[step++]);
        }
//        if (step >= actoins.length) {
//            step = 0;
//        }
        return getAction();
    }
}

package HomeTask.task7.TankGame.Tanks;


import HomeTask.task7.TankGame.ObjectsOnField.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 18/11/2015.
 */

public class Tiger extends AbstractTank {

    private int armor;

    public Tiger(BattleField bf) {
        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        armor = 1;
        setImage();
    }

    public Tiger(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        armor = 1;
        setImage();
    }
    private void setImage() {
        images = new Image[4];
        try {
            images[0] = ImageIO.read(new File("Tiger_UP.png").getAbsoluteFile());
            images[1] = ImageIO.read(new File("Tiger_DOWN.png").getAbsoluteFile());
            images[2] = ImageIO.read(new File("Tiger_LEFT.png").getAbsoluteFile());
            images[3] = ImageIO.read(new File("Tiger_RIGHT.png").getAbsoluteFile());
        }catch (IOException e) {
            throw new IllegalStateException("Can`t find tank image");
        }
    }

    @Override
    public void destroy() {
        if (armor > 0) {
            armor--;
        } else {
            super.destroy();
        }
    }

    @Override
    public Action setUp() {
        return getAction();
    }

}

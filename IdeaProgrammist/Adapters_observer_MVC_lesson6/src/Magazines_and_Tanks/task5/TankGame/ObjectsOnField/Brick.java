package Magazines_and_Tanks.task5.TankGame.ObjectsOnField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public class Brick extends AbstractObjectOnField {

    public Brick(int x, int y) {
        super(x, y);
        color = new Color(0, 0, 255);
        try {
            image = ImageIO.read(new File("Bricks.png").getAbsoluteFile());
        } catch (IOException e) {

        }
    }

}

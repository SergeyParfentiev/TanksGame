package Magazines_and_Tanks.task6.TankGame.ObjectsOnField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public class Rock extends AbstractObjectOnField {

    public Rock(int x, int y) {
        super(x, y);
        color =  new Color(255, 0, 0);
        try {
            image = ImageIO.read(new File("Rocks.png").getAbsoluteFile());
        } catch (IOException e) {

        }
    }


}

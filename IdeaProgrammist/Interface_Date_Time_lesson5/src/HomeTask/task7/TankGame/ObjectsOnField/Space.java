package HomeTask.task7.TankGame.ObjectsOnField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public class Space extends AbstractObjectOnField {

    public Space(int x, int y) {
        super(x, y);
        color = new Color(180, 180, 180);
        try {
            image = ImageIO.read(new File("Spaces.png").getAbsoluteFile());
        } catch (IOException e) {

        }
    }


}

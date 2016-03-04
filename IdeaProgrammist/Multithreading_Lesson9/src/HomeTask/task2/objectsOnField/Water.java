package HomeTask.task2.objectsOnField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public class Water extends AbstractObjectOnField {


    public Water(int x, int y) {
        super(x, y);
        color = new Color(255, 0, 0);
        try {
            water = ImageIO.read(new File("Waters.png").getAbsoluteFile());
        } catch (IOException e) {

        }
    }


}

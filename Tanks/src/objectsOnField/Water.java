package objectsOnField;

import java.awt.*;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public class Water extends AbstractObjectOnField {

    public Water(int x, int y, Image image) {
        super(x, y, image);
        color = new Color(0, 0, 255);
        numberInQueue = 6;
    }
}

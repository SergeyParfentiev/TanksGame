package objectsOnField;

import java.awt.*;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public class Rock extends AbstractObjectOnField {

    public Rock(int x, int y, Image image) {
        super(x, y, image);
        imageX = 8;
        numberInQueue = 3;
    }
}

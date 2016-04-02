package objectsOnField;

import java.awt.*;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public class Brick extends AbstractObjectOnField {

    public Brick(int x, int y, Image image) {
        super(x, y, image);
        numberInQueue = 4;
    }

}

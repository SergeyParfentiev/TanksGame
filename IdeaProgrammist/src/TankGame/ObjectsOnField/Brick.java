package TankGame.ObjectsOnField;

import TankGame.ObjectsOnField.AbstractObjectOnField;

import java.awt.*;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public class Brick extends AbstractObjectOnField {

    public Brick(int x, int y) {
        super(x, y);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(0, 0, 255));
        g.fillRect(getX(), getY(), 64, 64);

    }

}

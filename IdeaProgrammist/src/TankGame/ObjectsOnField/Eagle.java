package TankGame.ObjectsOnField;

import TankGame.ObjectsOnField.AbstractObjectOnField;

import java.awt.*;

/**
 * Created by Byblik272 on 2/12/2015.
 */
public class Eagle extends AbstractObjectOnField {

    public Eagle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 0));
        g.fillRect(getX(), getY(), 64, 64);
    }
}

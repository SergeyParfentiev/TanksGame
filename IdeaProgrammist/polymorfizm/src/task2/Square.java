package task2;

import java.awt.*;

/**
 * Created by Byblik272 on 20/11/2015.
 */
public class Square extends Rectangle{

    @Override
    public void draw(Graphics g) {

        color = new Color(0, 0, 0);
        g.setColor(color);
        x = 250; y = 100 + 150; h = 100; v = 100;
        g.drawRect(x, y, h, v);
        x = 275; y = 125 + 150; h = 50; v = 50;
        g.fillRect(x, y, h, v);
    }
}

package task2;

import java.awt.*;

/**
 * Created by Byblik272 on 19/11/2015.
 */
public class Rectangle extends AbstractShape {


    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(5.f));
        color = new Color(255, 100, 255);
        g.setColor(color);
        x = 250; y = 100; h = 100; v = 100;
        g.drawRect(x, y, h, v);
        x = 275; y = 125; h = 50; v = 50;
        g.fillRect(x, y, h, v);
    }


}

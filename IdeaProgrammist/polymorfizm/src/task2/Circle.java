package task2;

import java.awt.*;

/**
 * Created by Byblik272 on 19/11/2015.
 */
public class Circle extends AbstractShape {


     @Override
public void draw (Graphics g) {

    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(5f));
    color = new Color(0, 0, 255);
    g.setColor(color);
    x = 100; y = 100; h = 100; v = 100;
    g.drawOval(x, y, h, v);
    x = 125; y = 125; h = 50;  v = 50;
    g.fillOval(x, y, h, v);


}
}

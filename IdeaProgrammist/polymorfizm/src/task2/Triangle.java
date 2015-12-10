package task2;

import java.awt.*;

/**
 * Created by Byblik272 on 19/11/2015.
 */
public class Triangle extends AbstractShape {

    @Override
    public void draw(Graphics g) {

        int x1[] = {400, 500, 450};
        int y1[] = {200, 200, 100};
        int npoints = 3;

        int x2[] = {418, 482, 450};
        int y2[] = {189, 189, 125};


        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(5));
        color = new Color(100, 200, 100);
        g.setColor(color);
        g.drawPolygon(x1, y1, npoints);
        g.fillPolygon(x2, y2, npoints);


    }


}

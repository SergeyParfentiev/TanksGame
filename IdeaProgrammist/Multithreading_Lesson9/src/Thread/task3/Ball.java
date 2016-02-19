package Thread.task3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Byblik272 on 19/2/2016.
 */
public class Ball extends Thread{

    private int x;
    private int y;
    private int radius;
    private int speed;
    private int red;
    private int green;
    private int blue;
    private int step = 1;

    public Ball(int x, int y, int speed, Random random) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        radius = 30;
        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);
    }

    public void draw(Graphics g) {
        g.setColor(new Color(red, green, blue));
        g.fillOval(x, y, radius, radius);

    }

    @Override
    public void run() {

        while (true) {
                if((x + radius + step > 400) || x + step < 0) {
                    step = step * -1;
                }
                x = x + step;
            try {
                sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package Thread.task3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Byblik272 on 19/2/2016.
 */
public class FloatingBalls extends JPanel{

    private static final int WIDTH = 400 + 16;
    private static final int HEIGHT = 400 + 39;

    List<Ball> balls = new ArrayList<>();

    public FloatingBalls() {
        JFrame frame = new JFrame("FloatingBalls");
        frame.setLocation(600, 150);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        createBallsList();

    }

    private void createBallsList() {
        for(int i = 1; i < 11; i++) {
            Random random = new Random();
            Ball ball = new Ball(10, i * 30, i, random);
            ball.start();
            balls.add(ball);
        }
    }

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for(Ball ball : balls) {
        ball.draw(g);
    }
      repaint();
    }
}


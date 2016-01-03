package HomeTask.task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by Byblik272 on 3/1/2016.
 */
public class ClickCircle extends JPanel implements MouseListener{
    @Override
    public void setBounds(int x, int y, int width, int height) {

        Random random1 = new Random();
        Random random2 = new Random();
        super.setBounds(random1.nextInt(1001), random2.nextInt(601), 100, 100);

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillOval(0, 0, 100, 100);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        ClickCircle.this.setBounds(0, 0, 0, 0);

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

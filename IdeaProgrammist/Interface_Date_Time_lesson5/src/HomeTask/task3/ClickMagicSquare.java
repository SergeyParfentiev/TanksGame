package HomeTask.task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by Byblik272 on 3/1/2016.
 */
public class ClickMagicSquare extends JPanel implements MouseListener{
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(100, 100, 100, 100);
        addMouseListener(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        Random random = new Random();

        g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        g.fillRect(0, 0, 100, 100);
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        repaint();


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

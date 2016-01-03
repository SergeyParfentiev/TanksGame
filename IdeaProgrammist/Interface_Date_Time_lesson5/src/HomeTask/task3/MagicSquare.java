package HomeTask.task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by Byblik272 on 3/1/2016.
 */
public class MagicSquare extends JPanel implements MouseListener{

    public MagicSquare() {
        JFrame jFrame = new JFrame("Magic Square");
        jFrame.setLocation(400, 100);
        jFrame.setMinimumSize(new Dimension(400, 400));

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.getContentPane().add(this);
        jFrame.pack();
        jFrame.setVisible(true);

        addMouseListener(this);

    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random random = new Random();

        g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        g.fillRect(100, 100, 100, 100);
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

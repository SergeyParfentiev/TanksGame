package Graphics_2D.task8;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Byblik272 on 29/12/2015.
 */
public class Window extends JPanel{

  static  Color color;
    static int i = 0;


    public Window(int i) {

        JFrame frame = new JFrame("Mashka - 4erepaska");
        frame.setLocation(0, 100);
        frame.setMinimumSize(new Dimension(800, 600));

        JFrame jFrame = new JFrame("Serezhka - molodets");
        jFrame.setLocation(800, 100);
        jFrame.setMinimumSize(new Dimension(800, 600));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(i == 0) {
            color = Color.BLACK;
            frame.getContentPane().add(this);
            frame.pack();
            frame.setVisible(true);
        }else {
            color = Color.GREEN;
            jFrame.getContentPane().add(this);
            jFrame.pack();
            jFrame.setVisible(true);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(color);
        g.fillRect(0, 0, 800, 600);

    }

    public static void main(String[] args) throws Exception{
        Window window1 = new Window(i);
        window1.repaint();

        Thread.sleep(100);

        i = 1;
        Window window2 = new Window(i);
        window2.repaint();
    }
}

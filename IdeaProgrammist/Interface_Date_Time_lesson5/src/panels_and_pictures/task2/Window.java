package panels_and_pictures.task2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Byblik272 on 30/12/2015.
 */
public class Window extends JPanel{

    public void caption() {
        JFrame frame = new JFrame();
        frame.setLocation(0, 100);
        frame.setMinimumSize(new Dimension(800, 600));



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.getContentPane().add(this);
            frame.pack();
            frame.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.BLACK);
        Font font = new Font("Courier", Font.BOLD, 30);
        g.setFont(font);
        g.drawString("Mashka - 4erepaska", 100, 100);
        font = new Font("Arial", Font.BOLD + Font.ITALIC, 30);
        g.setFont(font);
        g.drawString("Mashka - 4erepaska", 100, 200);

    }
}

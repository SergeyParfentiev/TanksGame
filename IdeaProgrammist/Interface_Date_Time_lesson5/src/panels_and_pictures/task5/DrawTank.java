package panels_and_pictures.task5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 30/12/2015.
 */
public class DrawTank extends JPanel{

    private final static String IMAGE_NAME  = "tankSimple.png";
    private Image iTank;

    public DrawTank() {
        try {
            iTank = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can`t find image: " + IMAGE_NAME);
        }
    }

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
        g.setColor(Color.RED);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.BLACK);

        Font font = new Font("Courier", Font.BOLD, 30);
        g.setFont(font);
        g.drawString("Mashka - 4erepaska", 100, 100);

        font = new Font("Arial", Font.BOLD + Font.ITALIC, 30);
        g.setFont(font);
        g.drawString("Mashka - 4erepaska", 100, 200);

        g.setColor(new Color(34, 174, 93));
        g.draw3DRect(400, 200, 49, 49, true);
        g.setColor(Color.RED);
        g.fillRect(401, 201, 48, 48);

        g.drawImage(iTank, 100, 400, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}

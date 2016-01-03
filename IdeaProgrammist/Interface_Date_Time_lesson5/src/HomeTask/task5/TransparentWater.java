package HomeTask.task5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Byblik272 on 3/1/2016.
 */
public class TransparentWater extends JPanel{
    private final static String IMAGE_NAME  = "Water.png";
    private Image iWater;

    public TransparentWater() {
        JFrame jFrame = new JFrame();
        jFrame.setLocation(400, 100);
        jFrame.setMinimumSize(new Dimension(500, 400));
        jFrame.getContentPane().add(this);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

        try {
            iWater = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can`t find image: " + IMAGE_NAME);
        }
    }
    public static void main(String[] args) {

        TransparentWater transparentWater = new TransparentWater();




    }

    @Override
    protected void paintComponent(Graphics k) {
        super.paintComponent(k);
       Graphics2D g = (Graphics2D)k;
        g.setColor(Color.GREEN);

        g.fillRect(150, 100, 100, 100);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        g.drawImage(iWater, 100, 100, null);

    }
}

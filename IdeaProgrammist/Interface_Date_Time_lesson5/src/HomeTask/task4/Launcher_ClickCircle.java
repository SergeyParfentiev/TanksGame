package HomeTask.task4;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Byblik272 on 3/1/2016.
 */
public class Launcher_ClickCircle {
    public static void main(String[] args) throws Exception{

        ClickCircle clickCircle = new ClickCircle();
        JFrame jFrame = new JFrame("Click Circle");

        jFrame.setLocation(100, 000);
        jFrame.setMinimumSize(new Dimension(1200 + 16, 800 + 39));

        jFrame.add(clickCircle);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }
}

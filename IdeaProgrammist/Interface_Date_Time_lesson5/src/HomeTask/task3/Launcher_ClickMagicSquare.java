package HomeTask.task3;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Byblik272 on 3/1/2016.
 */
public class Launcher_ClickMagicSquare {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Click Square");
        jFrame.setLocation(400, 100);
        jFrame.setMinimumSize(new Dimension(350, 400));
        ClickMagicSquare clickMagicSquare = new ClickMagicSquare();
        jFrame.add(clickMagicSquare);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }
}

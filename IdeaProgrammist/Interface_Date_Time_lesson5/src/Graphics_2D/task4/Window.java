package Graphics_2D.task4;

import javax.swing.*;

/**
 * Created by Byblik272 on 29/12/2015.
 */
public class Window {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mashka - 4erepaska");
        frame.setSize(800, 600);
        frame.setLocation(300, 100);

        JFrame jFrame = new JFrame("Serezhka - molodets");
        jFrame.setBounds(300, 100, 800, 600);

        frame.setVisible(true);
        jFrame.setVisible(true);

    }
}

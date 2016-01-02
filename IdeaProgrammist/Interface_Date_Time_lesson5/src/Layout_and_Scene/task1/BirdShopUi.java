package Layout_and_Scene.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Byblik272 on 2/1/2016.
 */
public class BirdShopUi {


    public BirdShopUi() {

        JFrame f = new JFrame();
        f.setMinimumSize(new Dimension(800, 600));
        f.setLocation(400, 100);

        f.getContentPane().add(createSellingPanel());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private JPanel createSellingPanel() {
        JPanel panel = new JPanel();

        JLabel lName = new JLabel("Your name");
        JTextField tname = new JTextField(10);

        JRadioButton birdButton1 = new JRadioButton("Bird1");
        birdButton1.setMnemonic(KeyEvent.VK_Q);

        JRadioButton birdButton2 = new JRadioButton("Bird2");
        birdButton2.setMnemonic(KeyEvent.VK_W);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(birdButton1);
        buttonGroup.add(birdButton2);

        JLabel lcount = new JLabel("Count");
        JTextField tcount = new JTextField(5);

        JButton buy = new JButton("Buy");
        buy.setMnemonic(KeyEvent.VK_E);

        panel.add(lName);
        panel.add(tname);
        panel.add(birdButton1);
        panel.add(birdButton2);
        panel.add(lcount);
        panel.add(tcount);
        panel.add(buy);

        return panel;
    }
}

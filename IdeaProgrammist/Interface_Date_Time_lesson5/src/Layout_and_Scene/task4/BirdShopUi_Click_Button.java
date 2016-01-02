package Layout_and_Scene.task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created by Byblik272 on 2/1/2016.
 */
public class BirdShopUi_Click_Button {
    public BirdShopUi_Click_Button() {

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
        panel.setLayout(new GridBagLayout());

        JLabel lName = new JLabel("Your name: ");
        JTextField tname = new JTextField(10);

        JLabel lshopProducts = new JLabel("Birds: ");
        ButtonGroup buttonGroup = new ButtonGroup();

        JPanel pShopProducts = new JPanel();
        pShopProducts.setLayout(new GridLayout(2, 0, 0, 0));
        pShopProducts.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        JRadioButton r1 = new JRadioButton("Bird1");
        r1.setSelected(true);
        buttonGroup.add(r1);
        pShopProducts.add(r1);

        JRadioButton r2 = new JRadioButton("Bird2");
        buttonGroup.add(r2);
        pShopProducts.add(r2);
        buttonGroup.setSelected(r2.getModel(), false);


        JLabel lcount = new JLabel("Count");
        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField tcount = new JFormattedTextField(nf);
        tcount.setValue(1);
        tcount.setColumns(2);

        JButton buy = new JButton("Buy");

        panel.add(lName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(tname, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(lshopProducts, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(pShopProducts, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(lcount, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(tcount, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(buy, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));

        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Trunsaction is done!");
            }
        });

        return panel;
    }
}

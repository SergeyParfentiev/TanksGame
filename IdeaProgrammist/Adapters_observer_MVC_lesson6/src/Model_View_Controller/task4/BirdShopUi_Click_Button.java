package Model_View_Controller.task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Byblik272 on 2/1/2016.
 */
public class BirdShopUi_Click_Button {

    private BirdShop shop;
    private int birdIdx = 0;

    public BirdShopUi_Click_Button() {

        shop = new BirdShop();
        JFrame f = new JFrame("Bird Shop");
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
        final JTextField tname = new JTextField(10);

        JLabel lshopProducts = new JLabel("Birds: ");
        List<Bird> birds = shop.getBird();
        ButtonGroup buttonGroup = new ButtonGroup();

        JPanel pShopProducts = new JPanel();

        ActionListener rbListener = new RBListener();
        for(int i = 0; i < birds.size(); i++) {
            Bird bird = birds.get(i);
            JRadioButton radioButton= new JRadioButton(bird.toString());
            radioButton.setActionCommand(String.valueOf(i));
            radioButton.addActionListener(rbListener);
            if(i == 0) {
                radioButton.setSelected(true);
            }
            buttonGroup.add(radioButton);
            pShopProducts.add(radioButton);
        }

        pShopProducts.setLayout(new GridLayout(birds.size(), 0, 0, 0));
        pShopProducts.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        JLabel lcount = new JLabel("Count");
        NumberFormat nf = NumberFormat.getNumberInstance();
        final JFormattedTextField tcount = new JFormattedTextField(nf);
        tcount.setValue(1);
        tcount.setColumns(2);

        JButton buy = new JButton("Buy");

        JButton viewTransactions = new JButton("View Transactions");

        panel.add(lName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(tname, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(lshopProducts, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(pShopProducts, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(lcount, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(tcount, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(buy, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(viewTransactions, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0, 0), 0, 0));

        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Customer customer = new Customer();
                customer.setName(tname.getText());

                Bird bird = shop.getBird().get(birdIdx);
                int count = Integer.parseInt(tcount.getText());

                shop.sell(bird, customer, count);
            }
        });

        viewTransactions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionsFrame();
            }
        });

        return panel;
    }
private void transactionsFrame() {
    JFrame f = new JFrame("Transactions");
    f.setLocation(500, 300);

    f.getContentPane().add(transactionsPanel());

    f.pack();
    f.setVisible(true);
}
    private JPanel transactionsPanel() {
        JPanel panel = new JPanel();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        String[] columNames = {"TID", "Date", "Bird", "Count", "Customer"};
        List<Transaction> transactions = shop.allTransactions();
        Object[][] data = new Object[transactions.size()][];
        for(int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            Object[] tObject = new Object[]{transaction.getIdx(), simpleDateFormat.format(transaction.getDate()),
                    transaction.getBird().getName(), transaction.getCount(), transaction.getCustomer().getName()};
            data[i] = tObject;
        }

        JTable tTransactions = new JTable(data, columNames);
        tTransactions.getColumnModel().getColumn(1).setPreferredWidth(120);

        JScrollPane jScrollPane = new JScrollPane(tTransactions);
        panel.add(jScrollPane);
        return panel;
    }


    private class RBListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            birdIdx = Integer.parseInt(e.getActionCommand());
        }
    }
}

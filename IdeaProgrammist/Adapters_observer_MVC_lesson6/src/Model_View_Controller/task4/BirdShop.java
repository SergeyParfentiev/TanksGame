package Model_View_Controller.task4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Byblik272 on 10/1/2016.
 */
public class BirdShop {

    private int countBirds = 15;
    Bird bird;
    Bird[] birds = new Bird[countBirds];
    Transaction transaction;
    List<Transaction> transactions = new ArrayList<>();
    private int transactionIdx = 1;
    private Date date;

    public BirdShop() {
        addBird();
    }

    private void addBird() {
        bird = new Bird();
        bird.setName("Duck");
        bird.setCost(10);
        bird.setCount(12);
        addInstorage(bird);

        bird = new Bird();
        bird.setName("Eagle");
        bird.setCost(25);
        bird.setCount(10);
        addInstorage(bird);

        bird = new Bird();
        bird.setName("Gander");
        bird.setCost(15);
        bird.setCount(20);
        addInstorage(bird);

        bird = new Bird();
        bird.setName("Swan");
        bird.setCost(30);
        bird.setCount(8);
        addInstorage(bird);
    }

    private void addInstorage(Bird bird) {
        for (int i = 0; i < countBirds; i++) {
            if (birds[i] == null) {
                birds[i] = bird;
                return;
            }
        }
    }

    public List<Bird> getBird() {
        List list = new ArrayList();
        for (int i = 0; i < birds.length; i++) {
            if(birds[i] != null) {
                list.add(birds[i]);
            }
        }
        return list;
    }

    public void sell(Bird bird, Customer customerData, int count) {
        transaction = new Transaction();
        date = new Date();
        transaction.setBird(bird);
        transaction.setCustomer(customerData);
        transaction.setCount(count);
        transaction.setIdx(transactionIdx);
        transaction.setDate(date);

        transactions.add(transaction);
        transactionIdx++;
    }

    public List<Transaction> allTransactions() {
        return transactions;
    }
}

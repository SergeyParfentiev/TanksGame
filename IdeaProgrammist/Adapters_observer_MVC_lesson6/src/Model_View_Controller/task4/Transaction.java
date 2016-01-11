package Model_View_Controller.task4;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by Byblik272 on 11/1/2016.
 */
public class Transaction {

    private Customer customer;
    private Bird bird;
    private int count;
    private int idx;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

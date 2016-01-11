package Magazines_and_Tanks.task2;

/**
 * Created by Byblik272 on 10/1/2016.
 */
public class Bird {

    private String name;
    private int cost;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return getName() + " " + getCost();
    }
}

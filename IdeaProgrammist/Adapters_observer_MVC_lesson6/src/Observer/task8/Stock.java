package Observer.task8;

/**
 * Created by Byblik272 on 9/1/2016.
 */
public class Stock {

    private String name;

    public Stock(String name) {
        if (name == null) {
            name = this.getClass().getSimpleName();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

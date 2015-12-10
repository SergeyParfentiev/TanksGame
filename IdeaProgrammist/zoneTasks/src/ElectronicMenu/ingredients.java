package ElectronicMenu;

/**
 * Created by Byblik272 on 28/11/2015.
 */
public enum Ingredients {

    BLACK_COFFE(2), BLACK_TEA(1.5), GREEN_TEA(1), WATER(1), SUGAR(0.5), MILK(2), CHOCOLATE(3), BERGAMOT(2);

    double id;

    Ingredients(double id) {
        this.id = id;
    }

    public double getId() {
        return id;
    }

}

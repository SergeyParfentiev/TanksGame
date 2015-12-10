package ElectronicMenu;

/**
 * Created by Byblik272 on 28/11/2015.
 */
public abstract class AbstractDrink {

    protected String name;
    Ingredients ingredients;
    protected double price = ingredients.WATER.getId() + ingredients.SUGAR.getId();;

    protected abstract void drink();

}

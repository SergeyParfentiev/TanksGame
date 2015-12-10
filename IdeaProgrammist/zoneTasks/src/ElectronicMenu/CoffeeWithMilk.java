package ElectronicMenu;

/**
 * Created by Byblik272 on 28/11/2015.
 */
public class CoffeeWithMilk extends AbstractDrink{

    @Override
    protected void drink() {
        name = "Coffee with milk";
        super.price += ingredients.BLACK_COFFE.getId() + ingredients.MILK.getId();
        System.out.println(name + "       " + ingredients.BLACK_COFFE + ", " +  ingredients.WATER +
                ", " + ingredients.SUGAR + ", " + ingredients.MILK + "                " + price);
    }
}

package ElectronicMenu;

/**
 * Created by Byblik272 on 28/11/2015.
 */
public class Americano extends AbstractDrink{

    @Override
    protected void drink() {

        name = "Americano";
        super.price += ingredients.BLACK_COFFE.getId();

        System.out.println(name + "                " + ingredients.BLACK_COFFE + ", " +  ingredients.WATER +
                ", " + ingredients.SUGAR + "                    " + price);

    }
}

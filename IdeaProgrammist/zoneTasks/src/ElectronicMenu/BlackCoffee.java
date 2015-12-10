package ElectronicMenu;

/**
 * Created by Byblik272 on 28/11/2015.
 */
public class BlackCoffee extends AbstractDrink{


    @Override
    protected void drink() {

        name = "Black coffe";
        super.price += ingredients.BLACK_COFFE.getId();

        System.out.println(name + "              " + ingredients.BLACK_COFFE + ", " +  ingredients.WATER +
                ", " + ingredients.SUGAR + "                    " + price);

    }
}

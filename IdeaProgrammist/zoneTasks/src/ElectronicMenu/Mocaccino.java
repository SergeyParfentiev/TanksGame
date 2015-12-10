package ElectronicMenu;

/**
 * Created by Byblik272 on 28/11/2015.
 */
public class Mocaccino extends AbstractDrink{

    @Override
    protected void drink() {
        name = "Mocaccino";
        super.price += ingredients.BLACK_COFFE.getId() + ingredients.CHOCOLATE.getId();

        System.out.println(name + "            " + ingredients.BLACK_COFFE + ", " +  ingredients.WATER +
                ", " + ingredients.SUGAR + ", " + ingredients.CHOCOLATE + "             " + price);


    }
}

package ElectronicMenu;

/**
 * Created by Byblik272 on 28/11/2015.
 */
public class BlackTea extends AbstractDrink{
    @Override
    protected void drink() {

        name = "Black tea";
        super.price += ingredients.BLACK_TEA.getId();

        System.out.println(name + "                 " + ingredients.BLACK_TEA + ", " +  ingredients.WATER +
                ", " + ingredients.SUGAR + "                     " + price);
    }
}

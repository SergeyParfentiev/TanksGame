package ElectronicMenu;

/**
 * Created by Byblik272 on 28/11/2015.
 */
public class GreenTea extends AbstractDrink{

    @Override
    protected void drink() {

        name = "Green tea";
        super.price += ingredients.GREEN_TEA.getId();

        System.out.println(name + "                 " + ingredients.GREEN_TEA + ", " +  ingredients.WATER +
                ", " + ingredients.SUGAR + "                     " + price);
    }
}

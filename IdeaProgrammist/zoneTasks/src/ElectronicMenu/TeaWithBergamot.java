package ElectronicMenu;

/**
 * Created by Byblik272 on 28/11/2015.
 */
public class TeaWithBergamot extends AbstractDrink{
    @Override
    protected void drink() {

        name = "Tea with Bergamot";
        super.price += ingredients.BLACK_TEA.getId() + ingredients.BERGAMOT.getId();

        System.out.println(name + "     " + ingredients.BLACK_TEA + ", " +  ingredients.WATER + ", " +
                ingredients.BERGAMOT + ", " + ingredients.SUGAR + "               " + price);
    }
}

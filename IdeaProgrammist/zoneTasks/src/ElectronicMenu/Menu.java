package ElectronicMenu;

/**
 * Created by Byblik272 on 28/11/2015.
 */
public class Menu {


        AbstractDrink[] drinks = new AbstractDrink[15];

        private void drinksInMenu() {

            BlackCoffee blackCoffee = new BlackCoffee();
            addDrink(blackCoffee);
            CoffeeWithMilk coffeeWithMilk = new CoffeeWithMilk();
            addDrink(coffeeWithMilk);
            Americano americano = new Americano();
            addDrink(americano);
            Cappuccino cappuccino = new Cappuccino();
            addDrink(cappuccino);
            Mocaccino mocaccino = new Mocaccino();
            addDrink(mocaccino);
            BlackTea blackTea = new BlackTea();
            addDrink(blackTea);
            GreenTea greenTea = new GreenTea();
            addDrink(greenTea);
            TeaWithBergamot teaWithBergamot = new TeaWithBergamot();
            addDrink(teaWithBergamot);
        }



        public void printMenu() {
            drinksInMenu();

            System.out.println("Drinks name                  Drinks ingredients                   Drinks Price\n");
            for(int i = 0; i < drinks.length; i++) {
                if(drinks[i] != null){
                    drinks[i].drink();
                }
            }
        }

        private void addDrink(AbstractDrink drink) {
            for (int i = 0; i < drinks.length; i++) {
                if (drinks[i] == null) {
                    drinks[i] = drink;
                    return;
                }
            }
        }
}

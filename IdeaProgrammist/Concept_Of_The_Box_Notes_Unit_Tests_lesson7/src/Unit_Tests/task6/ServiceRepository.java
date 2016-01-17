package Unit_Tests.task6;

import java.util.Random;

/**
 * Created by Byblik272 on 14/1/2016.
 */
public class ServiceRepository<T extends Service> {

    public Client first;
    public Client second;

    public ServiceRepository() {
        first = new Client();
        second = new Client();
        first.setVip();
    }

    public void workOrder(T t) {
        if(t instanceof Cleaning) {
            amountOfMoney(first, t);
            if(t.getService())
            {
                System.out.println("Cleaned");
            }
        } else {
            amountOfMoney(second, t);
            if(t.getService()) {
                System.out.println("Painted");
            }
        }

    }

    private void amountOfMoney(Client client, T t) {
        Random random = new Random();
        int cash = random.nextInt(5) * 100;
        if(cash > 100 && client.isVip()) {
            t.doTheJob();
        } else if(cash > 200){
            t.doTheJob();
        }
    }
}

package Unit_Tests.task6;

/**
 * Created by Byblik272 on 14/1/2016.
 */
public class ServiceRepository_Launcher {
    public static void main(String[] args) {

        Cleaning cleaning = new Cleaning();
        Painting painting = new Painting();

        ServiceRepository<Service> service = new ServiceRepository<>();

        service.workOrder(cleaning);
        service.workOrder(painting);

    }
}

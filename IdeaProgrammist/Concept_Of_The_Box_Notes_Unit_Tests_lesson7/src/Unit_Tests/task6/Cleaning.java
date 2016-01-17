package Unit_Tests.task6;

/**
 * Created by Byblik272 on 14/1/2016.
 */
public class Cleaning implements Service{

    private boolean clean;

    @Override
    public void doTheJob() {
        clean = true;
    }
    @Override
    public boolean getService() {
        return clean;
    }
}

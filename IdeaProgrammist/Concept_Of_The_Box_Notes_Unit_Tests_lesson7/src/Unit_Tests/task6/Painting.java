package Unit_Tests.task6;

/**
 * Created by Byblik272 on 17/1/2016.
 */
public class Painting implements Service{

    private boolean painting;

    @Override
    public void doTheJob() {
        painting = true;
    }

    @Override
    public boolean getService() {
        return painting;
    }
}

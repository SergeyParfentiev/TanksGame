package homeTask.task1;

/**
 * Created by Byblik272 on 21/1/2016.
 */
@Service
public class Bird {

    @InitService
    public void name() {
        System.out.println(this.getClass().getSimpleName() + "\n");
    }
}

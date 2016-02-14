package HomeTask.task2.gameRecord;

import HomeTask.task2.tanks.Action;
import HomeTask.task2.tanks.Tank;

import java.io.Serializable;

/**
 * Created by Byblik272 on 14/2/2016.
 */
public interface FileOfRecord extends Serializable {

    void write(Action action, String fileName) throws Exception;
}

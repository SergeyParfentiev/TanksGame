package HomeTask.task2.gameRecord;

import HomeTask.task2.tanks.Action;
import HomeTask.task2.tanks.Direction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Byblik272 on 14/2/2016.
 */
public interface FileOfRecord extends Serializable {

    void write(Direction direction, Action action, String fileName) throws Exception;
    List read(String fileName) throws Exception;
}

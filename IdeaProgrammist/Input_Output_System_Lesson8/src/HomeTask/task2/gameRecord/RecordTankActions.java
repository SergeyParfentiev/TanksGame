package HomeTask.task2.gameRecord;

import HomeTask.task2.tanks.Action;
import HomeTask.task2.tanks.Tank;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Byblik272 on 14/2/2016.
 */
public class RecordTankActions implements FileOfRecord {

    Boolean apennd = true;

    @Override
    public void write(Action action, String fileName) throws Exception {

        FileOutputStream fos = new FileOutputStream(fileName, apennd);

        try (
                ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))
        ) {
            oos.writeObject(action);
        }
    }
}

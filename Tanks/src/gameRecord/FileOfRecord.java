package gameRecord;

import tanks.Action;
import tanks.Direction;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Byblik272 on 14/2/2016.
 */
public interface FileOfRecord extends Serializable {

    void write(String s, ObjectOutputStream oos, Direction direction, Action action);
    List read(String fileName);
}

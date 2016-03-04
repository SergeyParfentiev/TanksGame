package HomeTask.task2.gameRecord;

import HomeTask.task2.tanks.Action;
import HomeTask.task2.tanks.Direction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byblik272 on 14/2/2016.
 */
public class RecordTankActions implements FileOfRecord {

    Boolean apennd = false;
    List list = new ArrayList();

    @Override
    public void write(Direction direction, Action action, String fileName) throws Exception {

        FileOutputStream fos = new FileOutputStream(fileName, apennd);
        apennd = true;

        try (
                ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))
        ) {
            oos.writeObject(direction);
            oos.writeObject(action);
            oos.writeBytes("\r\n");
        }

    }

    @Override
    public List read(String fileName) throws Exception {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        RecordTankActions.this.readActions(bis);
//        System.out.println();
//        readList(list);
        return list;
    }

    private void readActions(BufferedInputStream bis) throws Exception {
        try{
            ObjectInputStream ois = new ObjectInputStream(bis);
            Direction direction = (Direction)ois.readObject();
            list.add(direction);
//            System.out.println(direction);
            Action action = (Action) ois.readObject();
            list.add(action);
//            System.out.println(action);
            ois.readByte();
            if(bis.available() > 0) {
                RecordTankActions.this.readActions(bis);
            } else {
                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println();
//        readList(list);
    }

    public static void readList(List list) throws Exception{
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static void main(String[] args) throws Exception {
        RecordTankActions r = new RecordTankActions();
        r.read("/GameRecord.txt");
    }
}

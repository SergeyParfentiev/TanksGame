package List.Students_in_ClassRoom;

import java.util.Arrays;

/**
 * Created by Byblik272 on 9/12/2015.
 */
public class LauncherClassRoom {
    public static void main(String[] args) {

        ClassRoom classRoom = new ClassRoom();

        classRoom.leave("Sylvester", "Stallone");
        classRoom.leave("Steven", "Stallone");
        classRoom.enter("Uma", "Thurman");
        classRoom.getStudentCount();
        classRoom.printStudentInfo();
        classRoom.isPresent("Jackie", "Chan");



    }
}

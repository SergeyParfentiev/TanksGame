package HomeTask.Task8;


/**
 * Created by Byblik272 on 25/12/2015.
 */
public class Launcher_SimpleArrayList {
    public static void main(String[] args) {

        SimpleArrayList simpleArrayList = new SimpleArrayList();

        simpleArrayList.add("a");
        simpleArrayList.add("b");
        simpleArrayList.add(1);
        simpleArrayList.add(null);
        simpleArrayList.remove(null);
        simpleArrayList.remove(1);

        for (Object object : simpleArrayList){
            System.out.println(object);
        }


    }
}

package HomeTask.task4;

/**
 * Created by Byblik272 on 18/2/2016.
 */
public class LauncherListToFile {
    public static void main(String[] args) {

        ListToFile listToFile = new ListToFile();
        listToFile.add("LoL");
        listToFile.add("LoL");
        listToFile.add(1);
        listToFile.remove(1);
        listToFile.add("1");

        for (Object o : listToFile) {
            System.out.println(o);
        }

        System.out.println(listToFile.contains(Integer.parseInt("1")));
        System.out.println(listToFile.contains("1"));

        System.out.println(listToFile.size());
    }
}

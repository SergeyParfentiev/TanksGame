package hashCode_equals.task6;

/**
 * Created by Byblik272 on 19/12/2015.
 */
public class equalsPersons {
    public static void main(String[] args) {

        Person p1 = new Person("Ivan",20,20000);
        Person p2 = new Person("Petr",30,30000);


        System.out.println(p1.equals(p2) + "\n");

        p2=p1;


        System.out.println(p1.equals(p2));

    }
}

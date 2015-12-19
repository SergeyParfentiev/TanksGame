package hashCode_equals.task6;

/**
 * Created by Byblik272 on 19/12/2015.
 */
public class equalsPersons {
    public static void main(String[] args) {

        Person person1 = new Person("JACKIE ", 2, 10);
        Person person2 = new Person("CHAN", 8, 0);


        System.out.println(person1.equals(person2) + "\n");

        person1 = person2;


        System.out.println(person1.equals(person2));

    }
}

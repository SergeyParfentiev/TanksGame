package hashCode_equals.task8;

/**
 * Created by Byblik272 on 20/12/2015.
 */
public class equalsPerson_withAdress {
    public static void main(String[] args) {


        Person person1 = new Person("JACKIE ", 2, 10, new Address("Magadan", "Coco", 8));
        Person person2 = new Person("CHAN", 8, 0, new Address("Coco", "Magadan", 7));


        System.out.println(person1.equals(person2) + "\n");

        person1 = person2;


        System.out.println(person1.equals(person2));

    }
}

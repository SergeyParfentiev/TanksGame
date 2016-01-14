package Generics.task3;


/**
 * Created by Byblik272 on 14/1/2016.
 */
public class Box_Launcher {
    public static void main(String[] args) {

        Box<Integer> boxI = new Box<>();

        boxI.setItem(1);
        boxI.setItem(2);
        boxI.remove(3);
        boxI.remove(2);

        System.out.println(boxI.getItems());

        Box<String> boxS = new Box<>();

        boxS.setItem("LoL");
        boxS.setItem("Smile");
        boxS.remove("2");
        boxS.remove("Smile");

        System.out.println(boxS.getItems());

        Box<Dog> dogBox = new Box<>();
        Dog dog = new Dog();
        dog.setAge(4);

        dogBox.setItem(dog);
        System.out.println(dogBox.getItem(11).getAge());
    }
}

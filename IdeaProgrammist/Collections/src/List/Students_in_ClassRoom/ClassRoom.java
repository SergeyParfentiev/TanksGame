package List.Students_in_ClassRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byblik272 on 9/12/2015.
 */
public class ClassRoom {

    public ClassRoom() {
        System.out.println("Class room\n");
        newClassRoom();
    }

    private List<Student> students = new ArrayList<>();

    private void newClassRoom() {
        students.add(new Student("Jackie", "Chan"));
        students.add(new Student("Bruce", "Lee"));
        students.add(new Student("Chuck", "Norris"));
        students.add(new Student("Steven", "Seagal"));
        students.add(new Student("Arnold", "Schwarzenegger"));
        students.add(new Student("Sylvester", "Stallone"));
        students.add(new Student("Jason", "Statham"));

    }

    public void enter(String name, String secondName) {
        students.add(new Student(name, secondName));
    }

    public void leave(String name, String secondName) {
        for(Student student : students) {
            if(student.getName() == name && student.getSecondName() == secondName) {
                students.remove(student);
            }
        }
    }

    public void getStudentCount() {
        System.out.println("Count is: " + students.size());
    }

    public void isPresent(String name, String secondName) {
        int idx = 0;
        for(Student student : students) {
            if(student.getName() == name && student.getSecondName() == secondName) {
                System.out.println(name + " " + secondName + " is present");
                idx++;
                }
            }
        if(idx == 0) {
            System.out.println(name + " " + secondName + " is not present");
        }
    }

    public void printStudentInfo() {
        for(Student student : students){
            System.out.println(student.getName() + " " + student.getSecondName());
        }
    }

}

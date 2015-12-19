package hashCode_equals.task6;

/**
 * Created by Byblik272 on 19/12/2015.
 */
public class Person {

    private String name;
    private int age;
    private long salary;

    public Person (String name,int age,long salary){
        this.name=name;
        this.age=age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        if (getSalary() != person.getSalary()) return false;
        return !(getName() != null ? !getName().equals(person.getName()) : person.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (int) (getSalary() ^ (getSalary() >>> 32));
        return result;
    }
}

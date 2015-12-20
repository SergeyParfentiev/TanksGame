package hashCode_equals.task8;

/**
 * Created by Byblik272 on 20/12/2015.
 */
public class Person {

    private String name;
    private int age;
    private long salary;
    private Address address;

    public Person (String name, int age, long salary, Address address){
        this.name=name;
        this.age=age;
        this.salary = salary;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        if (getSalary() != person.getSalary()) return false;
        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) return false;
        return !(address != null ? !address.equals(person.address) : person.address != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (int) (getSalary() ^ (getSalary() >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

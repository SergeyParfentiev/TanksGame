package hashCode_equals.task8;

/**
 * Created by Byblik272 on 20/12/2015.
 */
public class Address {

    private String city;
    private String street;
    private int house;

    public Address(String city, String street, int house) {
        if(city == null || street == null || house < 1){
            throw new IllegalStateException("Error");
        }
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (house != address.getHouse()) return false;
        if (city.equals(address.getCity())) return false;
        return !(street.equals(address.getStreet()));

    }

    @Override
    public int hashCode() {
        int result = 25;
        result = 37 * result * city.hashCode();
        result = 37 * result * street.hashCode();
        result = 37 * result * house;
        return result;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }
}

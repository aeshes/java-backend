package aoizora.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Address extends AbstractIdentifiableObject {

    private String city;
    private String street;
    private String home;

    @OneToMany(mappedBy = "address")
    private List<Person> dwellers;

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

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public List<Person> getDwellers() {
        return dwellers;
    }

    public void setDwellers(List<Person> dwellers) {
        this.dwellers = dwellers;
    }
}

package aoizora.booking;

import java.util.List;

public class Booking {

    private List<Person> persons;

    public Booking() {
    }

    public Booking(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persong) {
        this.persons = persong;
    }
}

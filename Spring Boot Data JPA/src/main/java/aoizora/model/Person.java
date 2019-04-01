package aoizora.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person extends AbstractIdentifiableObject {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", passport=" + passport +
                '}';
    }
}

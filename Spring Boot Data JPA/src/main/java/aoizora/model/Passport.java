package aoizora.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Passport extends AbstractIdentifiableObject {

    private String series;
    private String no;
    private LocalDate issueDate;
    private Period validity;
    @OneToOne(optional = false, mappedBy = "passport")
    private Person owner;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Period getValidity() {
        return validity;
    }

    public void setValidity(Period validity) {
        this.validity = validity;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "series='" + series + '\'' +
                ", no='" + no + '\'' +
                ", issueDate=" + issueDate +
                ", validity=" + validity +
                ", owner=" + owner +
                '}';
    }
}

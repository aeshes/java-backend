package aoizora.entities;

import java.util.Arrays;
import java.util.List;

public class Hero {

    private String name;
    private List<Integer> number = Arrays.asList(1, 2, 3);

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }
}

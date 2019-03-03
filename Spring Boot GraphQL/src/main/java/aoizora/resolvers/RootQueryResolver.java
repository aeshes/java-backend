package aoizora.resolvers;

import aoizora.entities.Hero;
import aoizora.entities.Person;
import aoizora.entities.User;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class RootQueryResolver implements GraphQLQueryResolver {

    public Person person(String who) {
        if (who.toLowerCase().equals("aoizora")) {
            return new Person("Aoizora", 28);
        }
        return new Person("Unknown", null);
    }

    public User me() {
        return new User(1, "Aoizora");
    }

    public Hero hero() {
        return new Hero("R2-D2");
    }
}

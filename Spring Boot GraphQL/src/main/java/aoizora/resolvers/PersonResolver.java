package aoizora.resolvers;

import aoizora.entities.Person;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class PersonResolver implements GraphQLResolver<Person> {

    public Integer getComplexValue(Person person) {
        return veryComplexFetchingOfValue(person.getName());
    }

    private int veryComplexFetchingOfValue(String name) {
        if (name.equals("Aoizora")) {
            return 42;
        }
        return 3;
    }
}

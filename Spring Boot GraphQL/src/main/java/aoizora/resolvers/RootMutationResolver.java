package aoizora.resolvers;

import aoizora.entities.Person;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class RootMutationResolver implements GraphQLMutationResolver {

    public Person newPerson(String name, Integer age) {
        Person person = new Person(name, age);
        System.out.println(person);
        return person;
    }
}

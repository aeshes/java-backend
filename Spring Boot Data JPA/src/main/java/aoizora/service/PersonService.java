package aoizora.service;

import aoizora.model.Person;
import aoizora.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person p) {
        return personRepository.save(p);
    }

    public Person find(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not exists"));
    }
}

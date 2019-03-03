package aoizora.service;

import aoizora.model.Greeting;
import aoizora.repository.JpaGreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private JpaGreetingRepository repository;

    public void save(Greeting greeting) {
        repository.addGreeting(greeting);
    }
}

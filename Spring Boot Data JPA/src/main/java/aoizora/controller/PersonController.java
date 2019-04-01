package aoizora.controller;

import aoizora.model.Person;
import aoizora.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private final static Log log = LogFactory.getLog(PersonController.class);

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person p) {
        log.info(p);
        return personService.save(p);
    }

    @GetMapping("/person/{id}")
    public Person findPerson(@PathVariable("id") Long id) {
        log.info("Person ID:" + id);
        return personService.find(id);
    }
}

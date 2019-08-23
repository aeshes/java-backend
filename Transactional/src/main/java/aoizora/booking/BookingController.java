package aoizora.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public void book(@RequestBody Booking persons) {
        List<Person> personList = Optional.ofNullable(persons)
                .map(Booking::getPersons)
                .orElseThrow(RuntimeException::new);
        bookingService.book(personList);
    }

    @GetMapping("/booking")
    public List<String> getAll() {
        return bookingService.findAll();
    }
}

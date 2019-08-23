package aoizora.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
public class BookingService {

    private final static Logger logger = LoggerFactory.getLogger(BookingService.class);
    private final JdbcTemplate jdbcTemplate;

    public BookingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void book(List<Person> persons) {
        for (Person person: persons) {
            logger.info("Booking " + person + " in a seat");
            jdbcTemplate.update("insert into booking(firstname) values (?)", person.getFirstname());
        }
    }

    public List<String> findAll() {
        return jdbcTemplate.query("select firstname from booking",
                (rs, rowNum) -> rs.getString("firstname"));
    }
}

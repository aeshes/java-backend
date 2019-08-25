package aoizora.booking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookingServiceTest {

    private BookingService bookingService;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Before
    public void before() {
        bookingService = new BookingService(jdbcTemplate);
    }

    @Test
    public void findAll() {
        when(jdbcTemplate.query(anyString(), (ResultSetExtractor<Object>) anyObject()))
                .thenReturn(Collections.singletonList("Test"));

        bookingService = new BookingService(jdbcTemplate);
        List<String> actual = bookingService.findAll();
        System.out.println(actual);

        assertThat(actual).size().isEqualTo(1);
        assertThat(actual.get(0)).isEqualTo("Test");
    }
}
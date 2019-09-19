package aoizora.repository;

import aoizora.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() {
        em.persist(new User("Alex", "Alex", "alex@mail.ru", 13));
        em.persist(new User("Mike", "Mike", "mike@gmail.com", 27));
        em.persist(new User("Jane", "Jane", "jane@mail.ru", 17));
        em.flush();
    }

    @Test
    public void test() {
        Optional<User> u = userRepository.findById(2L);
        u.ifPresent(System.out::println);
    }

    private Specification<User> hasAgeGreater(int age) {
        return (root, query, cb) -> {
            query.distinct(true);
            return null;
        };
    }
}
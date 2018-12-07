package main.repository;

import main.config.HibernateConfig;
import main.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfig.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void count() {
        assertEquals(2, repository.count());
    }

    @Test
    public void save() {
        User user = repository.save(new User("test_name", "test_password", "test_email"));
        assertNotNull(user.getId());
        System.out.println(user);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
        List<User> ls = repository.findAll();
        for (User user: ls) {
            System.out.println(user);
        }
    }
}
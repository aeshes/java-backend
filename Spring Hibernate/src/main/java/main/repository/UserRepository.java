package main.repository;

import main.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public long count() {
        return findAll().size();
    }

    public User save(User user) {
        Serializable id = currentSession().save(user);

        return new User((Long) id,
                user.getUsername(),
                user.getPassword(),
                user.getEmail());
    }

    public User findOne(Long id) {
        return currentSession().get(User.class, id);
    }

    public List<User> findAll() {
        return (List<User>) currentSession()
                .createCriteria(User.class).list();
    }
}

package aoizora.repository;

import aoizora.model.Greeting;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Repository
@Transactional
public class JpaGreetingRepository {

    @PersistenceContext
    private EntityManager em;

    @PersistenceUnit
    private EntityManagerFactory emf;

    public void addGreeting(Greeting greeting) {
        em.persist(greeting);
    }

    public Greeting findGreeting(Long id) {
        return em.find(Greeting.class, id);
    }

    public void saveGreeting(Greeting greeting) {
        em.merge(greeting);
    }
}

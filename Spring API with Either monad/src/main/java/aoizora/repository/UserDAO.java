package aoizora.repository;

import aoizora.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAO {

    private EntityManager em;

    @Autowired
    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public List<User> findUsersByNameAndAge(String name, int age) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        Predicate userNamePredicate = cb.equal(user.get("firstName"), name);
        Predicate userAgePredicate = cb.equal(user.get("age"), age);
        cq.where(userNamePredicate, userAgePredicate);

        TypedQuery<User> query = em.createQuery(cq);
        return query.getResultList();
    }
}

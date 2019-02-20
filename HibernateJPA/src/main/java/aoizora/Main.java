package aoizora;

import aoizora.entity.Greeting;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        write();
        read();
    }

    private static void write() {
        Greeting greeting = new Greeting();
        greeting.setGreeting("Hello");
        greeting.setTarget("JPA");

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("aoizora.jpa.hibernate");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(greeting);
        em.getTransaction().commit();
        em.close();
    }

    private static void read() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("aoizora.jpa.hibernate");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.createQuery("from Greeting", Greeting.class)
                .getResultList()
                .forEach(g -> System.out.println(
                        String.format("%s, %s!", g.getGreeting(), g.getTarget())));
        em.getTransaction().commit();
        em.close();
    }
}

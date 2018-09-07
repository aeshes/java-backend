package data;

import data.base.ConnectionManager;
import data.dao.ConnectionPGManager;
import data.model.Person;
import data.dao.PersonDAO;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class PersonDAOTest {

    @Test
    public void readPerson() {
        ConnectionManager connectionManager = new ConnectionPGManager();
        Connection connection = connectionManager.getConnection();
        PersonDAO personDAO = new PersonDAO(connection);
        Person person = personDAO.readPerson(666);
        assertEquals(person, new Person("Satanic", "Satan"));
    }
}
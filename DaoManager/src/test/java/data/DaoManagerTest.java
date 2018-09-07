package data;

import data.base.ConnectionManager;
import data.base.DaoCommand;
import data.dao.ConnectionPGManager;
import data.model.Person;
import data.dao.DaoManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class DaoManagerTest {

    @Test
    public void executeAndClose() {
        ConnectionManager connectionManager = new ConnectionPGManager();
        DaoManager daoManager = new DaoManager(connectionManager.getConnection());
        Person person = (Person)
                daoManager.executeAndClose(manager -> daoManager.getPersonDAO().readPerson(666));
        assertEquals(person, new Person("Satanic", "Satan"));
    }

    @Test
    public void transaction() {
        ConnectionManager connectionManager = new ConnectionPGManager();
        DaoManager daoManager = new DaoManager(connectionManager.getConnection());
        Person person = (Person)
                daoManager.transaction(manager -> daoManager.getPersonDAO().readPerson(666));
        assertEquals(person, new Person("Satanic", "Satan"));
    }
}
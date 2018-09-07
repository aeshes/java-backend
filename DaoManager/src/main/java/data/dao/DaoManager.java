package data.dao;

import data.base.DaoCommand;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoManager {

    protected Connection connection = null;
    protected PersonDAO personDao = null;

    public DaoManager(Connection connection) {
        this.connection = connection;
    }

    public PersonDAO getPersonDAO() {
        if (this.personDao == null) {
            this.personDao = new PersonDAO(connection);
        }
        return this.personDao;
    }

    public Object executeAndClose(DaoCommand command) {
        try {
            return command.execute(this);
        }
        finally {
            try { this.connection.close(); } catch (SQLException ignore) {}
        }
    }

    public Object transaction(DaoCommand command) {
        try {
            this.connection.setAutoCommit(false);
            Object ret = command.execute(this);
            this.connection.commit();
            return ret;
        }
        catch (SQLException e) {
            try { this.connection.rollback(); } catch (SQLException ignore) {}
            throw new RuntimeException(e);
        }
        finally {
            try { this.connection.setAutoCommit(true); } catch (SQLException ignore) {}
        }
    }
}

package data.dao;

import data.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO {

    private Connection connection = null;

    private static final String GET_PERSON_BY_ID = "select * from person where person_id = ?";

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    public Person readPerson(int personId) {
        Person person = null;

        try (PreparedStatement ps = connection.prepareStatement(GET_PERSON_BY_ID)) {
            ps.setInt(1, personId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                person = new Person(rs.getString(2), rs.getString(3));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return person;
    }
}

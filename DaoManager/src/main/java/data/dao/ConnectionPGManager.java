package data.dao;

import data.base.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPGManager implements ConnectionManager {

    private final static String DRIVER = "org.postgresql.Driver";
    private final static String DB_PATH = "jdbc:postgresql://localhost:5432/test";
    private final static String USER = "postgres";
    private final static String PASSWORD = "postgres";

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_PATH, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

package data.base;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}

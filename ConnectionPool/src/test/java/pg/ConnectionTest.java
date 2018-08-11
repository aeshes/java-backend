package pg;

import config.Config;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

    private ConnectionPool pool = null;
    private Connection connection = null;

    @BeforeSuite
    public void setup() {
        try {
            pool = new ConnectionPool(Config.PG_URL, Config.PG_USER, Config.PG_PASS);
        }
        catch (SQLException ignored) {}
    }

    @Test(invocationCount = 100)
    public void testSelectUser() {
        connection = pool.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select user_name from users where user_id = 1");
            if (rs.next()) {
                final String name = rs.getString(1);
                System.out.println(name);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            pool.releaseConnection(connection);

            try {
                if (rs != null)
                    rs.close();
            }
            catch (SQLException ignored) {}

            try {
                if (st != null)
                    st.close();
            }
            catch (SQLException ignored) {}
        }
    }
}

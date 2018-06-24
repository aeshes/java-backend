package servlets;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import mongo.MongoConnection;

public class MongoConnectionServlet implements ServletContextListener {

    public void contextInitialized(ServletContextEvent evt) {
        MongoConnection conn = MongoConnection.getInstance();
        conn.init();
    }

    public void contextDestroyed(ServletContextEvent evt) {
        MongoConnection conn = MongoConnection.getInstance();
        conn.close();
    }
}

package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.HelloWorld;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8086);
        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);
        ctx.setContextPath("/");
        server.setHandler(ctx);

        ctx.addServlet(new ServletHolder(new HelloWorld()), "/hello");

        try {
            server.start();
            server.join();
        }
        finally {
            server.destroy();
        }
    }
}

package aoizora.servlet;

import aoizora.graphql.Mutation;
import aoizora.graphql.Query;
import aoizora.repository.LinkRepository;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends HttpServlet {

    private SimpleGraphQLServlet servlet;

    public GraphQLEndpoint() {
        servlet = SimpleGraphQLServlet.builder(buildSchema()).build();
    }

    private static GraphQLSchema buildSchema() {
        LinkRepository linkRepository = new LinkRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(linkRepository))
                .resolvers(new Mutation(linkRepository))
                .build()
                .makeExecutableSchema();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        servlet.service(request, response);
    }
}

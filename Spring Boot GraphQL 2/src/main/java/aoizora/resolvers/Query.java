package aoizora.resolvers;

import aoizora.entities.Link;
import aoizora.repository.LinkRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private LinkRepository linkRepository;

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }
}
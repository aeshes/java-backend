package aoizora.graphql;

import aoizora.domain.Link;
import aoizora.repository.LinkRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class Query implements GraphQLQueryResolver {

    private final LinkRepository linkRepository;

    public Query(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }
}

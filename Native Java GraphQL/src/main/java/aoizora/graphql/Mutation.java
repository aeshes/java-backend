package aoizora.graphql;

import aoizora.domain.Link;
import aoizora.repository.LinkRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {

    private final LinkRepository linkRepository;

    public Mutation(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link createLink(String url, String description) {
        Link link = new Link(url, description);
        linkRepository.saveLink(link);
        return link;
    }
}

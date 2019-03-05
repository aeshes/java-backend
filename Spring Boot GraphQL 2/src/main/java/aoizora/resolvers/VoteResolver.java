package aoizora.resolvers;

import aoizora.entities.Link;
import aoizora.entities.User;
import aoizora.entities.Vote;
import aoizora.repository.LinkRepository;
import aoizora.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class VoteResolver implements GraphQLResolver<Vote> {

    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private UserRepository userRepository;

    public VoteResolver(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public User user(Vote vote) {
        return userRepository.findById(vote.getUserId());
    }

    public Link link(Vote vote) {
        return linkRepository.findById(vote.getLinkId());
    }
}

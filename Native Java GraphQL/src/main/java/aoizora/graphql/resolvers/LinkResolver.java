package aoizora.graphql.resolvers;

import aoizora.domain.Link;
import aoizora.domain.User;
import aoizora.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class LinkResolver implements GraphQLResolver<Link> {

    private final UserRepository userRepository;

    public LinkResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User postedBy(Link link) {
        if (link.getUserId() == null) {
            return null;
        }
        return userRepository.findById(link.getUserId());
    }
}

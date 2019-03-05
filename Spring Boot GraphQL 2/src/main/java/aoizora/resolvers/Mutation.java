package aoizora.resolvers;

import aoizora.entities.*;
import aoizora.repository.LinkRepository;
import aoizora.repository.UserRepository;
import aoizora.repository.VoteRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private UserRepository userRepository;
    private VoteRepository voteRepository;

    public Link createLink(String url, String description) {
        Link link = new Link(url, description, null);
        linkRepository.saveLink(link);
        return link;
    }

    public User createUser(String name, AuthData auth) {
        User user = new User(name, auth.getEmail(), auth.getPassword());
        return userRepository.saveUser(user);
    }

    public Vote createVote(String linkId, String userId) {
        ZonedDateTime now = Instant.now().atZone(ZoneOffset.UTC);
        return voteRepository.saveVote(new Vote(now, userId, userId));
    }

    public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getPassword())) {
            return new SigninPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }
}

package aoizora.graphql.resolvers;

import aoizora.domain.SigninPayload;
import aoizora.domain.User;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class SigninResolver implements GraphQLResolver<SigninPayload> {

    public User user(SigninPayload payload) {
        return payload.getUser();
    }
}

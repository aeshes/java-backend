package aoizora.model.mapper;

import aoizora.model.user.UserDTO;
import aoizora.domain.User;

public class UserMapper {
    public static UserDTO map(User user) {
        UserDTO result = new UserDTO();
        result.setId(user.getId());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setEmail(user.getEmail());
        result.setAge(user.getAge());

        return result;
    }
}

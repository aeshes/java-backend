package aoizora.service;

import aoizora.model.UserListRequest;
import aoizora.model.error.ErrorResponse;
import aoizora.model.mapper.UserMapper;
import aoizora.model.user.UserDTO;
import aoizora.domain.User;
import aoizora.repository.UserRepository;
import io.vavr.control.Either;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Either<ErrorResponse, Page<UserDTO>> findAll(UserListRequest request, Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return Either.right(page.map(UserMapper::map));
    }
}

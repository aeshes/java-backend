package aoizora.usecase;

import aoizora.entity.User;
import aoizora.usecase.exception.UserExistsException;
import aoizora.usecase.port.IDGenerator;
import aoizora.usecase.port.PasswordEncoder;
import aoizora.usecase.port.UserRepository;
import aoizora.usecase.validator.UserValidator;

public class CreateUser {

    private final UserRepository repository;
    private final IDGenerator generator;
    private final PasswordEncoder encoder;

    public CreateUser(UserRepository repository, IDGenerator generator, PasswordEncoder encoder) {
        this.repository = repository;
        this.generator = generator;
        this.encoder = encoder;
    }

    public User create(final User user) {
        UserValidator.validateCreateUser(user);
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserExistsException(user.getEmail());
        }
        var userToSave = User.newBuilder()
                .id(generator.generate())
                .email(user.getEmail())
                .password(encoder.encode(user.getEmail() + user.getPassword()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        return repository.create(userToSave);
    }
}

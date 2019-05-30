package aoizora.config;

import aoizora.encoder.SHA256PasswordEncoder;
import aoizora.id.UUIDGenerator;
import aoizora.repository.InMemoryUserRepository;
import aoizora.usecase.CreateUser;
import aoizora.usecase.FindUser;
import aoizora.usecase.port.IDGenerator;
import aoizora.usecase.port.PasswordEncoder;
import aoizora.usecase.port.UserRepository;

public class ManualConfig {

    private final UserRepository userRepository = new InMemoryUserRepository();
    private final IDGenerator generator = new UUIDGenerator();
    private final PasswordEncoder passwordEncoder = new SHA256PasswordEncoder();

    public CreateUser createUser() {
        return new CreateUser(userRepository, generator, passwordEncoder);
    }

    public FindUser findUser() {
        return new FindUser(userRepository);
    }
}

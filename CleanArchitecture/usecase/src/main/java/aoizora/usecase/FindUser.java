package aoizora.usecase;

import aoizora.entity.User;
import aoizora.usecase.port.UserRepository;

import java.util.List;
import java.util.Optional;

public class FindUser {

    private final UserRepository repository;

    public FindUser(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findById(final String id) {
        return repository.findById(id);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }
}

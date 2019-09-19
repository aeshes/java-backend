package aoizora;


import aoizora.domain.User;
import aoizora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("Kaylee", "James", "kaylee@gmail.com", 37));
        userRepository.save(new User("Jack", "Fox", "jack@gmail.com", 15));
        userRepository.save(new User("Kate", "Middleton", "kate@gmail.com", 20));
        userRepository.save(new User("James", "Wolly", "james@gmail.com", 25));
    }
}

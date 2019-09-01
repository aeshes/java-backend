package aoizora;

import aoizora.entity.Role;
import aoizora.entity.User;
import aoizora.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    public class InitRunner implements CommandLineRunner {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        public void run(String... args) throws Exception {
            User user = new User();
            user.setId(UUID.randomUUID());
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.grantAuthority(Role.ROLE_USER);

            User admin = new User();
            admin.setId(UUID.randomUUID());
            admin.setUsername("root");
            admin.setPassword(passwordEncoder.encode("toor"));
            admin.grantAuthority(Role.ROLE_ADMIN);

            userRepository.save(user);
            userRepository.save(admin);
        }
    }
}

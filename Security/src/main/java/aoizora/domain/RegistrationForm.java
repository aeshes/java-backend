package aoizora.domain;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public TacoUser toUser(PasswordEncoder encoder) {
        return new TacoUser(UUID.randomUUID(),username, encoder.encode(password),
                fullname, street, city, state, zip, phone);
    }
}

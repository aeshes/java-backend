package aoizora.jpa;

import aoizora.domain.TacoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<TacoUser, UUID> {
    TacoUser findByUsername(String username);
}

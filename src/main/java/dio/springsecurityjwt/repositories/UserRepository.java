package dio.springsecurityjwt.repositories;

import dio.springsecurityjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    boolean existsByUsername(String username);
}

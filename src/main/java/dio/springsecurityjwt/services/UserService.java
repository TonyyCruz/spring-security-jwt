package dio.springsecurityjwt.services;

import dio.springsecurityjwt.models.User;
import dio.springsecurityjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    public User create(User user) {
        String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        return repository.save(user);
    }
}

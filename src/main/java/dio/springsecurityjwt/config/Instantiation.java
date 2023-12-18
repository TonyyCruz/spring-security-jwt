package dio.springsecurityjwt.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.TimeZone;

import dio.springsecurityjwt.models.User;
import dio.springsecurityjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User tony = new User(null, "Anthony Cruz", "Anthony", encoder.encode("Anthony01"));
        User bia = new User(null, "Bianca Alves", "bia", encoder.encode("bia01"));
        User maria = new User(null, "Maria Brown", "maria", encoder.encode("maria01"));
        User alex = new User(null, "Alex Green", "alex", encoder.encode("alex01"));
        User bob = new User(null, "Bob Grey", "bob", encoder.encode("bob01"));
        userRepository.saveAll(Arrays.asList(tony, bia, maria, alex, bob));

    }

    private Instant dateFormat(String date) {
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
            formater.setTimeZone(TimeZone.getTimeZone("GMT"));
            return formater.parse(date).toInstant();
        } catch (Exception e) {
            e.printStackTrace();
            return Instant.now();
        }
    }

}

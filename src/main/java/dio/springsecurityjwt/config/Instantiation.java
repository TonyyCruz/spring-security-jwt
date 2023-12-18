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

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User tony = new User(null, "Anthony Cruz", "Anthony", "Anthony01");
        User bia = new User(null, "Bianca Alves", "bia", "bia01");
        User maria = new User(null, "Maria Brown", "maria", "maria01");
        User alex = new User(null, "Alex Green", "alex", "alex01");
        User bob = new User(null, "Bob Grey", "bob", "bob01");
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

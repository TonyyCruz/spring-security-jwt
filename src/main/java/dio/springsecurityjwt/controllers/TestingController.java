package dio.springsecurityjwt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestingController {

    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }

    @GetMapping("/users")
    public String users() {
        return "Authorized user";
    }

    @GetMapping("/managers")
    public String managers() {
        return "Authorized manager";
    }
}

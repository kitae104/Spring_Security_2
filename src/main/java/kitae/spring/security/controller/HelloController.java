package kitae.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Spring Security World!";
    }

    @GetMapping("/bye")
    public String bye() {
        return "See you later! Bye!";
    }
}

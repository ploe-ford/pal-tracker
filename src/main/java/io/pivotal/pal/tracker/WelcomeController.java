package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    String message = "hello";

    public WelcomeController(@Value("${WELCOME_MESSAGE :Hello from test}") String msg)
    {
        message = msg;
    }

    @GetMapping("/")
    public String sayHello () {
        return message;
    }
}

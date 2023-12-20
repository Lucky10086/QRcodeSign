package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author zjy
 */
@SpringBootApplication
public class SignApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SignApplication.class, args);
    }

}

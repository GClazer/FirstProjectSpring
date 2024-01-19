package com.clazerti.demo.config;

import com.clazerti.demo.entities.User;
import com.clazerti.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User lais = new User(null, "Lais", "Clazer", "lais@gmail.com", "456");
        User ademir = new User(null, "Ademir", "Clazer", "ademir@gmail.com", "789");

        // Save database
        userRepository.saveAll(Arrays.asList(lais, ademir));
    }
}
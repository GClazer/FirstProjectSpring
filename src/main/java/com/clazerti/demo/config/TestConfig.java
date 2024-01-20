package com.clazerti.demo.config;

import com.clazerti.demo.entities.Order;
import com.clazerti.demo.entities.User;
import com.clazerti.demo.repositories.OrderRepository;
import com.clazerti.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        this.userSeeder();
        this.orderSeeder();
    }

    private void userSeeder() {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User("Lais", "Clazer", "lais@gmail.com", "456"));
        users.add(new User("Ademir", "Clazer", "ademir@gmail.com", "789"));
        users.add(new User("Gabriel", "Clazer", "gabriel@gmail.com", "756"));

        userRepository.saveAll(users);
    }

    private void orderSeeder() {
        ArrayList<Order> orders = new ArrayList<>();

        User lais = userRepository.findById(1L).orElse(null);
        User ademir = userRepository.findById(2L).orElse(null);
        User gabriel = userRepository.findById(3L).orElse(null);

        orders.add(new Order(Instant.parse("2024-01-20T10:07:00Z"), lais));
        orders.add(new Order(Instant.parse("2024-01-20T20:08:30Z"), ademir));
        orders.add(new Order(Instant.parse("2024-01-20T01:35:40-03:00"), gabriel));

        orderRepository.saveAll(orders);
    }
}

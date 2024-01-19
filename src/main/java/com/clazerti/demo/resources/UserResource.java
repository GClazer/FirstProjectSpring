package com.clazerti.demo.resources;

import com.clazerti.demo.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<ArrayList<User>> getAll() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            User user = new User(1L, "Gabriel " + i, "Clazer " + i, "gabriel@gmail.com " + i, "123");
            users.add(user);
        }

        return ResponseEntity.ok().body(users);
    }
}

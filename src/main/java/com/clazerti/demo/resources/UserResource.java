package com.clazerti.demo.resources;

import com.clazerti.demo.entities.User;
import com.clazerti.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) throws Exception {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}

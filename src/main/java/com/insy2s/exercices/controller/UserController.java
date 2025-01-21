package com.insy2s.exercices.controller;

import com.insy2s.exercices.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final HashSet<User> users = new HashSet<>();

    @GetMapping
    public ResponseEntity<HashSet<User>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return ResponseEntity.status(HttpStatus.OK).body(user);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody User user) {
        return users.add(user) ?
            ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur ajouté avec l'id " + user.getId()) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quelque chose ne va pas");
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> put(@PathVariable int id, @RequestBody User user) {
        for (User u : users) {
            if (u.getId() == id) {
                if (user.getName() != null) {
                    u.setName(user.getName());
                }
                if (user.getEmail() != null) {
                    u.setEmail(user.getEmail());
                }
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        return (users.removeIf(user -> user.getId() == id)) ?
                ResponseEntity.status(HttpStatus.OK).build():
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}

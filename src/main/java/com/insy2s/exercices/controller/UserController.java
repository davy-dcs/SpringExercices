package com.insy2s.exercices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private static final Map<Integer, String> users = new HashMap<>();
    static {
        users.put(0, "Fethi");
        users.put(1, "Davy");
        users.put(2, "Pierre");
        users.put(3, "Paul");
        users.put(4, "Jacques");
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable int id) {
        if (users.containsKey(id)){
            return "Utilisateur : " + users.get(id);
        } else {
            return "Utilisateur incorrect";
        }
    }

    @GetMapping("/user/all")
    public ResponseEntity<Map<Integer,String>> users() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(users);
    }
}

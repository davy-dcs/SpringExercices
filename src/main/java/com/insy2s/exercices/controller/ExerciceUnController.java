package com.insy2s.exercices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciceUnController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Bonjour, " + name + " !";
    }
}

package com.insy2s.exercices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {
    @GetMapping("/convert")
    public String convert(@RequestParam(value="celsius") int C) {
        return C + "°C = " + ((C*9/5) + 32) + "°F";
    }
}

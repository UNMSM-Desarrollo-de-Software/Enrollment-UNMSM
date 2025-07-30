package com.lmp.unmsm.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/saludo")
    public Map<String, String> saludar() {
        return Map.of("mensaje", "Hola desde Spring Boot");
    }
}

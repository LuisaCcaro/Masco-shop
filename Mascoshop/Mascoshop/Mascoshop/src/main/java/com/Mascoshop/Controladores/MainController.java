package com.Mascoshop.Controladores;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping("/")
    public String index() {
        return "index"; // Asegúrate de que este archivo existe en src/main/resources/templates si usas Thymeleaf
    }
}

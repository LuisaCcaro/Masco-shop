package com.Mascoshop.Controladores;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Control {
    @GetMapping("/Inicio")
    public String informacion(){
        return "Hola mundo :D";
    }
}

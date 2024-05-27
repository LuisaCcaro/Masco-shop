package com.Mascoshop.Controladores;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({NoHandlerFoundException.class})
    public ModelAndView handleNoHandlerFoundExceptio(
            NoHandlerFoundException ex, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("error404"); // Nombre del archivo HTML personalizado sin la extensión
        modelAndView.addObject("message", "Resource not found"); // Puedes agregar más atributos si lo necesitas
        return modelAndView;
    }
}

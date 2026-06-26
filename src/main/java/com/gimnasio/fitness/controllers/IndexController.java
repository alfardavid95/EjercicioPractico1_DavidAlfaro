package com.gimnasio.fitness.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

    @GetMapping("/contacto/enviar")
    public String enviarContacto(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensaje",
                "Gracias por contactarnos. Su comentario fue recibido correctamente.");
        return "redirect:/contacto";
    }
}
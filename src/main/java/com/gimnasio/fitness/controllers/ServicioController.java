package com.gimnasio.fitness.controllers;

import com.gimnasio.fitness.domain.Servicio;
import com.gimnasio.fitness.service.CategoriaService;
import com.gimnasio.fitness.service.ServicioService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    private final ServicioService servicioService;
    private final CategoriaService categoriaService;

    public ServicioController(ServicioService servicioService, CategoriaService categoriaService) {
        this.servicioService = servicioService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("servicios", servicioService.getServicios());
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "servicio/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Servicio servicio, RedirectAttributes redirectAttributes) {
        servicioService.save(servicio);
        redirectAttributes.addFlashAttribute("mensaje", "Servicio guardado correctamente.");
        return "redirect:/servicio/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Integer id, Model model) {
        Servicio servicio = servicioService.getServicio(id).orElse(null);
        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "servicio/modifica";
    }

    @PostMapping("/eliminar")
    public String eliminar(Servicio servicio, RedirectAttributes redirectAttributes) {
        try {
            servicioService.delete(servicio.getId());
            redirectAttributes.addFlashAttribute("mensaje", "Servicio eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error",
                    "No se puede eliminar el servicio porque tiene reservas asociadas.");
        }

        return "redirect:/servicio/listado";
    }
}
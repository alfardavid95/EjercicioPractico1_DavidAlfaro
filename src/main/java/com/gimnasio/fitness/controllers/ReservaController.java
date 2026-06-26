package com.gimnasio.fitness.controllers;

import com.gimnasio.fitness.domain.Reserva;
import com.gimnasio.fitness.service.ReservaService;
import com.gimnasio.fitness.service.ServicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    private final ReservaService reservaService;
    private final ServicioService servicioService;

    public ReservaController(ReservaService reservaService, ServicioService servicioService) {
        this.reservaService = reservaService;
        this.servicioService = servicioService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("reservas", reservaService.getReservas());
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("servicios", servicioService.getServicios());
        return "reserva/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Reserva reserva, RedirectAttributes redirectAttributes) {
        reservaService.save(reserva);
        redirectAttributes.addFlashAttribute("mensaje", "Reserva guardada correctamente.");
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Integer id, Model model) {
        Reserva reserva = reservaService.getReserva(id).orElse(null);
        model.addAttribute("reserva", reserva);
        model.addAttribute("servicios", servicioService.getServicios());
        return "reserva/modifica";
    }

    @PostMapping("/eliminar")
    public String eliminar(Reserva reserva, RedirectAttributes redirectAttributes) {
        reservaService.delete(reserva.getId());
        redirectAttributes.addFlashAttribute("mensaje", "Reserva eliminada correctamente.");
        return "redirect:/reserva/listado";
    }
}
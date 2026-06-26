package com.gimnasio.fitness.controllers;

import com.gimnasio.fitness.domain.Categoria;
import com.gimnasio.fitness.service.CategoriaService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("categoria", new Categoria());
        return "categoria/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Categoria categoria, RedirectAttributes redirectAttributes) {
        categoriaService.save(categoria);
        redirectAttributes.addFlashAttribute("mensaje", "Categoría guardada correctamente.");
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Integer id, Model model) {
        Categoria categoria = categoriaService.getCategoria(id).orElse(null);
        model.addAttribute("categoria", categoria);
        return "categoria/modifica";
    }

    @PostMapping("/eliminar")
    public String eliminar(Categoria categoria, RedirectAttributes redirectAttributes) {
        try {
            categoriaService.delete(categoria.getId());
            redirectAttributes.addFlashAttribute("mensaje", "Categoría eliminada correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error",
                    "No se puede eliminar la categoría porque tiene servicios asociados.");
        }

        return "redirect:/categoria/listado";
    }
}
package com.gimnasio.fitness.service;

import com.gimnasio.fitness.domain.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> getCategorias();

    Optional<Categoria> getCategoria(Integer id);

    void save(Categoria categoria);

    void delete(Integer id);
}
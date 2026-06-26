package com.gimnasio.fitness.serviceimpl;

import com.gimnasio.fitness.domain.Categoria;
import com.gimnasio.fitness.repository.CategoriaRepository;
import com.gimnasio.fitness.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Categoria> getCategoria(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
package com.gimnasio.fitness.serviceimpl;

import com.gimnasio.fitness.domain.Servicio;
import com.gimnasio.fitness.repository.ServicioRepository;
import com.gimnasio.fitness.service.ServicioService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> getServicios() {
        return servicioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Servicio> getServicio(Integer id) {
        return servicioRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        servicioRepository.deleteById(id);
    }
}
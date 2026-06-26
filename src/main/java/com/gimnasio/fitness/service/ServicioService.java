package com.gimnasio.fitness.service;

import com.gimnasio.fitness.domain.Servicio;
import java.util.List;
import java.util.Optional;

public interface ServicioService {

    List<Servicio> getServicios();

    Optional<Servicio> getServicio(Integer id);

    void save(Servicio servicio);

    void delete(Integer id);
}
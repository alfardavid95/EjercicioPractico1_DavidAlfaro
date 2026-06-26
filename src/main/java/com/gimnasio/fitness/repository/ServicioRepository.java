package com.gimnasio.fitness.repository;

import com.gimnasio.fitness.domain.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}
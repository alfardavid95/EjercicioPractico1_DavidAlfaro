package com.gimnasio.fitness.repository;

import com.gimnasio.fitness.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
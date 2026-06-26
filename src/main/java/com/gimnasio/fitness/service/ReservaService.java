package com.gimnasio.fitness.service;

import com.gimnasio.fitness.domain.Reserva;
import java.util.List;
import java.util.Optional;

public interface ReservaService {

    List<Reserva> getReservas();

    Optional<Reserva> getReserva(Integer id);

    void save(Reserva reserva);

    void delete(Integer id);
}
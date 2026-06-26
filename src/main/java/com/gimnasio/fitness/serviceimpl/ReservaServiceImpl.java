package com.gimnasio.fitness.serviceimpl;

import com.gimnasio.fitness.domain.Reserva;
import com.gimnasio.fitness.repository.ReservaRepository;
import com.gimnasio.fitness.service.ReservaService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reserva> getReserva(Integer id) {
        return reservaRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        reservaRepository.deleteById(id);
    }
}
package com.reservas.bosco.services;

import com.reservas.bosco.entities.Reserva;
import com.reservas.bosco.repositories.IReservaRepository;
import com.reservas.bosco.utils.CopyProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservaService implements IReservaService{

    private final IReservaRepository reservaRepository;

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Optional<Reserva> insertReserva(Reserva reserva) {
        return Optional.of(reservaRepository.save(reserva));
    }

    @Override
    public Optional<Reserva> updateReserva(Long id, Reserva reservaUpdated) {
        return reservaRepository.findById(id)
                .map(reserva -> {
                    CopyProperties.copyProperties(reserva, reservaUpdated);

                    return reservaRepository.save(reserva);
                });
    }

    @Override
    public Optional<Reserva> deleteReserva(Long id) {
        return reservaRepository.findById(id)
                .map(reserva -> {
                    reservaRepository.delete(reserva);
                    return reserva;
                });
    }
}

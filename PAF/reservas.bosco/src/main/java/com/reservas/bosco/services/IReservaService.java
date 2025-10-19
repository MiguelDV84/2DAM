package com.reservas.bosco.services;

import com.reservas.bosco.entities.Reserva;

import java.util.List;
import java.util.Optional;

public interface IReservaService {
    List<Reserva> findAll();
    Optional<Reserva> findById(Long id);
    Optional<Reserva> insertReserva(Reserva reserva);
    Optional<Reserva> updateReserva(Long id,Reserva reserva);
    Optional<Reserva> deleteReserva(Long id);
}

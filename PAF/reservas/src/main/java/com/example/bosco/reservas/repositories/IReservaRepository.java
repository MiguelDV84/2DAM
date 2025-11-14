package com.example.bosco.reservas.repositories;

import com.example.bosco.reservas.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository extends JpaRepository<Reserva, Long> {

}

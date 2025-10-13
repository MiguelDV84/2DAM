package com.reservas.bosco.repositories;

import com.reservas.bosco.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository extends JpaRepository<Reserva, Long> {

}

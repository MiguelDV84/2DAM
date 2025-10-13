package com.reservas.bosco.repositories;

import com.reservas.bosco.entities.Aula;
import com.reservas.bosco.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAulaRepository extends JpaRepository<Aula, Long> {
    List<Reserva> findReserveOfAula(Long idReserva);
    List<Aula> findByCapacidad(int capacidad);
    List<Aula> findAulasWithComputers(boolean conComputadora);
}

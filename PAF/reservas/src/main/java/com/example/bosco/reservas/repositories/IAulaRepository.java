package com.example.bosco.reservas.repositories;

import com.example.bosco.reservas.entities.Aula;
import com.example.bosco.reservas.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAulaRepository extends JpaRepository<Aula, Long> {
   // List<Reserva> findReserveOfAula(Long idReserva);
    //List<Aula> findByCapacidad(int capacidad);
    //List<Aula> findAulasWithComputers(boolean conComputadora);
}

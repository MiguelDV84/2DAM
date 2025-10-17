package com.reservas.bosco.repositories;

import com.reservas.bosco.entities.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAulaRepository extends JpaRepository<Aula, Long> {
    Optional<List<Aula>> findByCapacidad(int capacidad);
    Optional<List<Aula>> findAulasWithComputers(boolean conComputadora);
    Optional<List<Aula>> findReserveOfAula(Long idReserva);
}

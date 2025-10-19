package com.reservas.bosco.repositories;

import com.reservas.bosco.entities.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAulaRepository extends JpaRepository<Aula, Long> {
    List<Aula> findByCapacidad(int capacidad);
    List<Aula> findByEsAulaDeOrdenador(boolean esAulaDeOrdenador);

    @Query("""
            select a from Aula a
            join a.reservas r
            where r.idReserva = :idReserva""")
    List<Aula> findReserveOfAula(Long idReserva);
}

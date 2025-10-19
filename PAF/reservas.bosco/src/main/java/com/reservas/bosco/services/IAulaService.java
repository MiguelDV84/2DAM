package com.reservas.bosco.services;

import com.reservas.bosco.entities.Aula;

import java.util.List;
import java.util.Optional;

public interface IAulaService {
    List<Aula> findAll();
    Optional<Aula> findById(Long id);
    List<Aula> findByCapacidad(int capacidad);
    List<Aula> findAulasEsDeOrdenadores(boolean esAulaDeOrdenadores);
    List<Aula> findReserveOfAula(Long idReserva);
    Optional<Aula> updateAula(Long id, Aula updatedAula);
    Optional<Aula> deleteAula(Long id);
    Optional<Aula> insertAula(Aula aula);
}

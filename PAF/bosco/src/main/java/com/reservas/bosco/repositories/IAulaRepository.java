package com.reservas.bosco.repositories;

import com.reservas.bosco.entities.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAulaRepository extends JpaRepository<Aula, Long> {
}

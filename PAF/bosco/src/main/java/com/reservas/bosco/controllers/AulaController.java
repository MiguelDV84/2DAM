package com.reservas.bosco.controllers;

import com.reservas.bosco.entities.Aula;
import com.reservas.bosco.repositories.IAulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")
@RequiredArgsConstructor
public class AulaController {

    IAulaRepository aulaRepository;
    
    @GetMapping
    public ResponseEntity<List<Aula>> findAll() {
        return ResponseEntity.ok(aulaRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Aula> findById(@PathVariable Long id) {
        return ResponseEntity.of(aulaRepository.findById(id));
    }

    @GetMapping("/capacidad/{capacidad}")
    public ResponseEntity<List<Aula>> findByCapacidad(@PathVariable int capacidad) {
        return ResponseEntity.of(aulaRepository.findByCapacidad(capacidad)
                .map(aulas -> aulas.stream().filter(aula -> aula.getCapacidad() == capacidad).toList()));
    }

    @GetMapping("/ordenadores/{conComputadora}")
    public ResponseEntity<List<Aula>> findAulasWithComputers(@PathVariable boolean conOrdenadores) {
        return ResponseEntity.of(aulaRepository.findAulasWithComputers(conOrdenadores)
                .map(aulas -> aulas.stream().filter(aula -> aula.isEsAulaDeOrdenador() == conOrdenadores).toList()));
    }

    @GetMapping("/reservas/{idReserva}")
    public ResponseEntity<List<Aula>> findReserveOfAula(@PathVariable Long idReserva) {
        return ResponseEntity.of(aulaRepository.findReserveOfAula(idReserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> updateAula(@PathVariable Long id, @RequestBody Aula updatedAula) {
        return aulaRepository.findById(id)
                .map(aula -> {
                    aula.setNombre(updatedAula.getNombre());
                    aula.setCapacidad(updatedAula.getCapacidad());
                    aula.setEsAulaDeOrdenador(updatedAula.isEsAulaDeOrdenador());
                    Aula savedAula = aulaRepository.save(aula);
                    return ResponseEntity.ok(savedAula);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aula> deleteAula(@PathVariable Long id) {
        return aulaRepository.findById(id)
                .map(aula -> {
                    aulaRepository.delete(aula);
                    aulaRepository.save();
                }).orElse(ResponseEntity.notFound().build());
    }
}

package com.example.bosco.reservas.controllers;

import com.example.bosco.reservas.entities.Aula;
import com.example.bosco.reservas.repositories.IAulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AulaController {

    @Autowired
    private final IAulaRepository aulaRepository;

    @GetMapping("/aulas")
    public ResponseEntity<List<Aula>> findAllAulas() {
        return ResponseEntity.ok(aulaRepository.findAll());
    }

    @GetMapping("/aula/{id}")
    public ResponseEntity<Aula> findAulaById(@PathVariable Long id) {
        return aulaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/aula/{id}")
    public ResponseEntity<Aula> updateAula(@PathVariable Long id, @RequestBody Aula aula) {
        return aulaRepository.findById(id)
                .map(a -> {
                    a.setNombre(aula.getNombre());
                    a.setCapacidad(aula.getCapacidad());
                    a.setEsAulaDeOrdenador(aula.getEsAulaDeOrdenador());
                    Aula aulaActualizada = aulaRepository.save(a);
                    return ResponseEntity.ok(aulaActualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/aula")
    public ResponseEntity<Aula> createAula(@RequestBody Aula aula) {
        Aula nuevaAula = aulaRepository.save(aula);
        return ResponseEntity.status(201).body(nuevaAula);
    }

    @DeleteMapping("/aula/{id}")
    public ResponseEntity<Void> deleteAula(@PathVariable Long id) {
        if (!aulaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        aulaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

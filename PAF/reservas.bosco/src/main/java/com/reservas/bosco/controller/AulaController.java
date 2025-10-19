package com.reservas.bosco.controller;

import com.reservas.bosco.entities.Aula;
import com.reservas.bosco.services.IAulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
@RequiredArgsConstructor
public class AulaController {
    private final IAulaService aulaService;

    @GetMapping
    public ResponseEntity<List<Aula>> findAll() {
        return ResponseEntity.ok(aulaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> findById(@PathVariable Long id) {
        return ResponseEntity.of(aulaService.findById(id));
    }

    @GetMapping("/capacidad/{capacidad}")
    public ResponseEntity<List<Aula>> findByCapacidad(@PathVariable int capacidad) {
        return ResponseEntity.ok(aulaService.findByCapacidad(capacidad));
    }

    @GetMapping("/ordenadores/{conOrdenadores}")
    public ResponseEntity<List<Aula>> findByConOrdenadores(@PathVariable boolean conOrdenadores) {
        return ResponseEntity.ok(aulaService.findAulasEsDeOrdenadores(conOrdenadores));
    }

    @GetMapping("/reservas/{idReserva}")
    public ResponseEntity<List<Aula>> findByReserva(@PathVariable long idReserva) {
        return ResponseEntity.ok(aulaService.findReserveOfAula(idReserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> updateAula(@PathVariable Long id, @RequestBody Aula updatedAula) {
        return aulaService.updateAula(id, updatedAula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aula> insertAula(@RequestBody Aula aula) {
        return aulaService.insertAula(aula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aula> deleteAula(@PathVariable Long id) {
        return aulaService.deleteAula(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

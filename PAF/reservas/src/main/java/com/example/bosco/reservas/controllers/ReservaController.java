package com.example.bosco.reservas.controllers;

import com.example.bosco.reservas.entities.Reserva;
import com.example.bosco.reservas.repositories.IReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservaController {

    @Autowired
    private final IReservaRepository reservaRepository;

    @GetMapping("/reservas")
    public ResponseEntity<List<Reserva>> findAll() {
        return ResponseEntity.ok(reservaRepository.findAll());
    }

    @GetMapping("/reserva/{id}")
    public ResponseEntity<Reserva> findReservaById(@PathVariable Long id) {
        return reservaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/reserva/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaRepository.findById(id)
                .map(r -> {
                    r.setFecha(reserva.getFecha());
                    r.setMotivo(reserva.getMotivo());
                    r.setNumeroAsistentes(reserva.getNumeroAsistentes());
                    r.setFechaCreacion(reserva.getFechaCreacion());
                    r.setAula(reserva.getAula());
                    r.setHorarios(reserva.getHorarios());
                    Reserva reservaActualizada = reservaRepository.save(r);
                    return ResponseEntity.ok(reservaActualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/reserva")
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaRepository.save(reserva);
        return ResponseEntity.status(201).body(nuevaReserva);
    }

    @DeleteMapping("/reserva/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        if (!reservaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        reservaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

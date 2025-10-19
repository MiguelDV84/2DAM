package com.reservas.bosco.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserva")
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private LocalDate fecha;

    private String motivo;

    private int numeroAsistentes;

    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @OneToMany(mappedBy = "reserva")
    private List<Horario> horarios;
}

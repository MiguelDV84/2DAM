package com.reservas.bosco.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aula")
@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAula;


    private String nombre;

    private int capacidad;

    private boolean esAulaDeOrdenador;

    private int numeroOrdenadores;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reservas;
}

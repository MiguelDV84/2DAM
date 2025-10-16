package com.example.bosco.reservas.entities;

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

    @Column(name = "nombre", nullable = false, length = 50 )
    private String nombre;

    @Column(name = "capacidad", nullable = false, length = 50 )
    private int capacidad;

    @Column(name = "es_aula_de_ordenador", nullable = false )
    private boolean esAulaDeOrdenador;

    @Column(name = "numero_ordenadores" )
    private int numeroOrdenadores;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reservas;

    public boolean getEsAulaDeOrdenador() {
        return esAulaDeOrdenador;
    }
}

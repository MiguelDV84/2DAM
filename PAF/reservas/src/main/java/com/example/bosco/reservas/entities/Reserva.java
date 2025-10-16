package com.example.bosco.reservas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

    @Column(name = "fecha",
            nullable = false,
            length = 100)
    private LocalDate fecha;

    @Column(name = "motivo",
            nullable = false,
            length = 255)
    private String motivo;

    @Column(name = "numero_asistentes",
            nullable = false)
    private int numeroAsistentes;

    @CreationTimestamp
    @Column(name = "fecha_creacion",
            nullable = false,
            updatable = false,
            length = 100)
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @OneToMany(mappedBy = "reserva")
    private List<Horario> horarios;
}

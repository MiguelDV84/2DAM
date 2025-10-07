package org.mdv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private String oficio;
    private String fechaAlta;
    private double salario;
    private int comision;
    private int idDepartamento;

    public Empleado(String nombre, String apellido, String oficio, String fechaAlta, int salario, int comision, int idDepartamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.oficio = oficio;
        this.fechaAlta = fechaAlta;
        this.salario = salario;
        this.comision = comision;
        this.idDepartamento = idDepartamento;
    }
}

package org.mdv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private String oficio;
    private String fechaAlta;
    private int salario;
    private int comision;
    private int idDepartamento;
}

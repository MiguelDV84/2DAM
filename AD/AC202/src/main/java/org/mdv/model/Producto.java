package org.mdv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Producto {
    private String codigo;
    private String descripcion;
    private double precioRecomendado;
    private int existencias;
}

package org.mdv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VentaDetalle {
    private int id;
    private int idVenta;
    private String codigoProducto;
    private int cantidad;
    private double precioUnitario;
    private double totalLinea;
}

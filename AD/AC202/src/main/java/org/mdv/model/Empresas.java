package org.mdv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empresas {
    private String cif;
    private String nombre;
    private String domicilio;
    private String localidad;
    private String logitpo;
    private String colores;
}

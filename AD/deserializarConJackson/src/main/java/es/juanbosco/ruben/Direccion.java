package es.juanbosco.ruben;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
    private String ciudad;
    private String calle;
    private int codigoPostal;
}

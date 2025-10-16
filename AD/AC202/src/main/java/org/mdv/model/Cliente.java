package org.mdv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {
    private String dni;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String dirHabitual;
    private String dirEnvio;

    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre + ", Apellidos: " + apellidos +
               ", Teléfono: " + telefono + ", Dirección Habitual: " + dirHabitual +
               ", Dirección de Envío: " + dirEnvio;
    }
}

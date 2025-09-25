package es.juanbosco.ruben;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private List<String> telefonos;
    private Direccion direccion;


}

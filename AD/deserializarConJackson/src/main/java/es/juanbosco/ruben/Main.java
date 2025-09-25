package es.juanbosco.ruben;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper om = new ObjectMapper();
        File file = new File("usuarios.json");
        Usuarios wrapper = om.readValue(file, Usuarios.class);


        mostrarUsuarios(wrapper);

    }

    public static void mostrarUsuarios(Usuarios us){
        StringBuilder sb = new StringBuilder();
        for(Usuario usuarios : us.getUsuarios()) {
            System.out.println("Id: " + usuarios.getId() +
                    " | Nombre: " + usuarios.getNombre() +
                    " | Email: " + usuarios.getEmail() +
                    " | Telefonos: " + usuarios.getTelefonos() +
                    " | Dirección: " + usuarios.getDireccion().getCalle() +
                    ", " + usuarios.getDireccion().getCiudad() +
                    " (" + usuarios.getDireccion().getCodigoPostal() + ")");


        }

    }
}
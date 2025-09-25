package org.example.controller;

import org.example.model.Carta;
import org.example.model.Tablero;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class GameController {
    private final Tablero tablero;
    private final List<JButton> botones;
    private Integer primeraSeleccion = null;
    //private boolean bloqueado = false;

    public GameController(Tablero tablero, List<JButton> botones) {
        this.tablero = tablero;
        this.botones = botones;

        for (int i = 0; i < botones.size(); i++) {
            JButton b = botones.get(i);
            b.addActionListener(crearListener(i));
        }
    }

    private ActionListener crearListener(int index) {
        return e -> {
            int valorCarta = tablero.getCartas().get(index).getId();
            if(primeraSeleccion == null) {
                primeraSeleccion = valorCarta;
                mostrar(index, tablero.getCartas().get(index));
                System.out.println("PRIMERA SELECCION: " + primeraSeleccion);
            } else {
                int segundaSelecion = valorCarta;
                mostrar(index, tablero.getCartas().get(index));

                Carta c1 = new Carta(tablero.getCartas().get(primeraSeleccion).getId());
                Carta c2 = new Carta(tablero.getCartas().get(segundaSelecion).getId());

                if(!c1.equals(c2)) {
                    ocultar(primeraSeleccion);
                    ocultar(segundaSelecion);
                    System.out.println("No son iguales");
                    System.out.println("1: " + c1.getId() + " 2: " + c2.getId());
                }
                System.out.println("SEGUNDA SELECCION: " + segundaSelecion);
                primeraSeleccion = null;
            }
        };
    }

    private void mostrar(int index, Carta carta) {
        JButton boton = botones.get(index);
        boton.setText(String.valueOf(carta.getId()));
    }

    private void ocultar(int index) {
        JButton boton = botones.get(index);
        boton.setText("X");
    }

}

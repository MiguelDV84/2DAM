package org.example.controller;
import javax.swing.Timer;
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
            int segundaSeleccion;
            if(primeraSeleccion == null){
                primeraSeleccion = index;
                mostrar(index,tablero.getCartas().get(index).getId());

            } else {
                segundaSeleccion = index;
                mostrar(index,tablero.getCartas().get(index).getId());

                Carta c1 = tablero.getCartas().get(primeraSeleccion);
                Carta c2 = tablero.getCartas().get(segundaSeleccion);
                if(c1.getId() != c2.getId()){
                    System.out.println("NO SON IGUALES!!!1");
                    System.out.println("Carta 1: " + c1.getId());
                    System.out.println("Carta 2: " + c2.getId());
                    Timer t = new Timer(1000, ev -> {
                        ocultar(primeraSeleccion); // <-- Asegúrate: ocultar recibe ÍNDICE
                        ocultar(segundaSeleccion);
                        primeraSeleccion = null;
                    });
                    t.setRepeats(false);
                    t.start();
                } else {
                    System.out.println("SON IGUALES");
                    System.out.println("Carta 1: " + c1.getId());
                    System.out.println("Carta 2: " + c2.getId());
                    primeraSeleccion = null;
                }

            }
        };
    }

    private void mostrar(int index, int valorCarta) {
        JButton boton = botones.get(index);
        boton.setText(String.valueOf(valorCarta));
    }

    private void ocultar(int index) {
        JButton boton = botones.get(index);
        boton.setText("X");
    }

}

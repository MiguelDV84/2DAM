package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tablero {
    public int getParejas() {
        return parejas;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    private final int parejas;
    private final int filas;
    private final int columnas;
    private final List<Carta> cartas;

    public Tablero(int parejas, int filas, int columnas) {
        this.parejas = parejas;
        this.filas = filas;
        this.columnas = columnas;
        this.cartas = construirCartas(parejas);
    }

    private List<Carta> construirCartas(int parejas) {
        List<Carta> lista = new ArrayList<>(parejas);
        for (int i = 0; i < parejas ; i++) {
            lista.add(new Carta(i));
            lista.add(new Carta(i));
        }

        return lista;
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }


}

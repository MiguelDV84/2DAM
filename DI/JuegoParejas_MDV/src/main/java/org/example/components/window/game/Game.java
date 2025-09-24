package org.example.components.window.game;

import org.example.components.window.Window;
import org.example.controller.GameController;
import org.example.model.Tablero;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends Window {
    private GameController controller;
    public final Tablero tablero;
    private final List<JButton> botones = new ArrayList<>();

    public Game(Tablero tablero) {
        super("Juego de Parejas",400,600,true);
        this.tablero = tablero;

        JPanel panel = new JPanel(new GridLayout(tablero.getFilas(),tablero.getColumnas(),10,10));
        for (int i = 0; i < tablero.getCartas().size() ; i++) {
            JButton boton = new JButton("X"); // de momento, mostramos su valor
            panel.add(boton);
            botones.add(boton);
        }

        add(panel);
        controller = new GameController(tablero,botones);

    }
}

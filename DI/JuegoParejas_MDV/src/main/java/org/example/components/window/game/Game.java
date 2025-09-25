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

    public Game(Tablero tablero) {
        super("Juego de Parejas",400,600,true);
        this.tablero = tablero;

        JPanel panel = new JPanel(new GridLayout(tablero.getFilas(),tablero.getColumnas(),10,10));
        List<JButton> botones = new ArrayList<>();
        for (int i = 0; i < tablero.getCartas().size() ; i++) {
            JButton boton = new JButton("X"); // de momento, mostramos su valor
            panel.add(boton);
            botones.add(boton);
        }

        add(panel);
        controller = new GameController(tablero, botones);
        JDialog dialogo = new JDialog(this, "Tablero", true); // true = modal
        dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialogo.getContentPane().add(panel);
        dialogo.pack();                        // ajusta al contenido
        dialogo.setLocationRelativeTo(this);   // centra respecto a la ventana principal
        dialogo.setSize(400,600);
        dialogo.setVisible(true);

    }
}

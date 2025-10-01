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


        JPanel mainPanel = new JPanel(new BorderLayout());
        int contador = 0;
        //Panel superior
        JPanel topPanel = new JPanel();
        JLabel contadorLabel = new JLabel("Parejas encontradas: " + contador);
        topPanel.add(contadorLabel);

        // Panel central
        JPanel gridPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(tablero.getFilas(),tablero.getColumnas(),10,10);
        gridPanel.setLayout(gridLayout);
        List<JButton> botones = new ArrayList<>();
        for (int i = 0; i < tablero.getCartas().size() ; i++) {
            JButton boton = new JButton("X");
            gridPanel.add(boton);
            botones.add(boton);
        }

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(gridPanel, BorderLayout.CENTER);

        add(mainPanel);
        this.controller = new GameController(tablero, botones,contadorLabel);
        JDialog dialogo = new JDialog(this, "Tablero", true); // true = modal
        dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialogo.getContentPane().add(mainPanel);
        dialogo.pack();                        // ajusta al contenido
        dialogo.setLocationRelativeTo(this);   // centra respecto a la ventana principal
        dialogo.setSize(400,600);
        dialogo.setVisible(true);

    }
}

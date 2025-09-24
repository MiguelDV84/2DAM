package org.example.window.game;

import org.example.window.Window;

import javax.swing.*;
import java.awt.*;

public class Game extends Window {
    public Game() {
        super("Bienvenido",400,600,true);

        // GridLayuout 2 filas x 5 columnas
        JPanel panel = new JPanel(new GridLayout(2,5,10,10));

        // 🔹 Añadimos 10 botones al panel
        for (int i = 0; i <= 9; i++) {
            JButton boton = new JButton(""+i);
            panel.add(boton);
        }

        add(panel);
    }
}

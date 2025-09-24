package org.example.window.game;

import org.example.window.Window;

import javax.swing.*;
import java.awt.*;

public class Game extends Window {

    public Game(int size) {
        super("Juego de Parejas",400,600,true);

        JPanel panel = new JPanel(new GridLayout(2,5,10,10));

        for (int i = 0; i <= size-1; i++) {
            JButton boton = new JButton(""+i);
            panel.add(boton);
        }

        add(panel);
    }
}

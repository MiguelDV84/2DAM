package org.example.window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window (String title, int width, int height, boolean resizable) {
        setTitle(title);
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(resizable);

        // GridLayuout 2 filas x 5 columnas
        JPanel panel = new JPanel(new GridLayout(2,5,10,10));

        // 🔹 Añadimos 10 botones al panel
        for (int i = 0; i <= 9; i++) {
            JButton boton = new JButton(""+i);
            panel.add(boton);
        }

        add(panel);

        setVisible(true);

    }
}

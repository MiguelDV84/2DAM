package org.example.components.window.welcome;

import org.example.components.window.Window;
import org.example.components.window.game.Game;
import org.example.model.Tablero;

import javax.swing.*;
import java.awt.*;

public class Welcome extends Window {

    public Welcome() {
        super("Juego de Parejas - Bienvenido",400,600,true);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 50));

        JLabel title = new JLabel("Bienvenido",SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD,18));
        panel.add(title,BorderLayout.CENTER);

        JButton startBtn = new JButton("Iniciar Juego");
        startBtn.setFont(new Font("Arial", Font.PLAIN, 10));

        startBtn.addActionListener(e -> {
            dispose();
            Tablero tablero = new Tablero(5, 2, 5);
            tablero.barajar();
            new Game(tablero);
        });

        panel.add(startBtn, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

}

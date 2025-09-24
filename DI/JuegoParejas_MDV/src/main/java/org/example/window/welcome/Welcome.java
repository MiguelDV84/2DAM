package org.example.window.welcome;

import org.example.window.Window;
import org.example.window.game.Game;

import javax.swing.*;
import java.awt.*;

public class Welcome extends Window {

    public Welcome() {
        super("Juego de Parejas - Bienvenido",400,600,true);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Bienvenido");
        title.setFont(new Font("Arial", Font.BOLD,18));
        panel.add(title,BorderLayout.CENTER);

        JButton startBtn = new JButton("Iniciar Juego");
        startBtn.setFont(new Font("Arial", Font.PLAIN, 16));

        startBtn.addActionListener(e -> {
            dispose();
            new Game();
        });

        panel.add(startBtn, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

}

package org.example.components.window.welcome;

import org.example.components.window.Window;
import org.example.components.window.game.Game;
import org.example.model.Tablero;

import javax.swing.*;
import java.awt.*;

public class Welcome extends Window {

    public Welcome() {
        super("Juego de Parejas - Bienvenido",400,600,true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        // TITULO
        JLabel title = new JLabel("Bienvenido",SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD,18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title,BorderLayout.CENTER);

        panel.add(Box.createRigidArea(new Dimension(0,20)));
        //
        JLabel cantidadParejasLabel = new JLabel("Parejas:");
        cantidadParejasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cantidadParejasLabel);

        JTextField cantidadParejas = new JTextField(10);
        cantidadParejas.setMaximumSize(new Dimension(200, 30));
        panel.add(cantidadParejas);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton startBtn = new JButton("Iniciar Juego");
        startBtn.setFont(new Font("Arial", Font.PLAIN, 10));
        startBtn.addActionListener(e -> {
            dispose();
            Tablero tablero = new Tablero(Integer.parseInt(cantidadParejas.getText()), 0,0,2,5);
            tablero.barajar();
            new Game(tablero);
        });
        panel.add(startBtn, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

}

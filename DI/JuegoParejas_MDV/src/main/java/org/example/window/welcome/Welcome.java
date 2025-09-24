package org.example.window.welcome;

import org.example.window.Window;

import javax.swing.*;
import java.awt.*;

public class Welcome extends Window {

    public Welcome() {
        super("Juego de Parejas - Bienvenido",400,200,true);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Bienvenido");
        title.setFont(new Font("Arial", Font.BOLD,18));
        panel.add(title,BorderLayout.CENTER);
        setVisible(true);
    }

}

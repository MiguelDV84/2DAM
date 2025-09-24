package org.example.window;

import javax.swing.*;

public class Window extends JFrame {

    public Window (String title, int width, int height, boolean resizable) {
        setTitle(title);
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(resizable);

        setVisible(true);
    }
}

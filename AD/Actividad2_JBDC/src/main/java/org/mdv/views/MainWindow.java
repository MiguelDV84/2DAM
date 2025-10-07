package org.mdv.views;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MainWindow extends JFrame {
    public MainWindow() {
        try {
            // Cambiar apariencia a Nimbus
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}
        setTitle("Ventana Inicio");
        setSize(400, 300);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelBtns = new JPanel();
        panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnEmpleados = new JButton("Empleados");
        btnEmpleados.addActionListener(e -> {
            try {
                new EmployedWindow();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        JButton btnDepartamentos = new JButton("Departamentos");
        btnDepartamentos.addActionListener(e -> new DepartamentWindow());

        panelBtns.add(btnEmpleados);
        panelBtns.add(btnDepartamentos);

        add(panelBtns, BorderLayout.SOUTH);

        setVisible(true);
    }
}

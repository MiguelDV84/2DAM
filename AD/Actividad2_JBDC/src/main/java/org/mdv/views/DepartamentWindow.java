package org.mdv.views;

import javax.swing.*;
import java.awt.*;

public class DepartamentWindow extends JFrame {
    public DepartamentWindow() {
        setTitle("Departamentos");
        setSize(400, 300);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelTitle = new JPanel();
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle = new JLabel("Gestión de Departamentos");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        panelTitle.add(lblTitle);
        add(panelTitle, BorderLayout.NORTH);

        // Panel central con campos de texto
        JPanel PANEL_CENTER = new JPanel();
        PANEL_CENTER.setLayout(new GridLayout(3, 2, 10, 10));
        PANEL_CENTER.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel lblId = new JLabel("Codigo departamento:");
        JTextField txtId = new JTextField();

        JLabel lblName = new JLabel("Nombre departamento:");
        JTextField txtName = new JTextField();

        JLabel lblLocalidad = new JLabel("Localidad:");
        JTextField txtLocalidad = new JTextField();

        PANEL_CENTER.add(lblId);
        PANEL_CENTER.add(txtId);
        PANEL_CENTER.add(lblName);
        PANEL_CENTER.add(txtName);
        PANEL_CENTER.add(lblLocalidad);
        PANEL_CENTER.add(txtLocalidad);

        add(PANEL_CENTER, BorderLayout.CENTER);


        // Botones inferiores
        JPanel panelBtns = new JPanel();
        panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnPrimero = new JButton("Primero");
        btnPrimero.addActionListener(e -> System.out.println("Btn Primero"));

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(e -> System.out.println("Btn Siguiente"));

        JButton btnAnterior = new JButton("Anterior");
        btnAnterior.addActionListener(e -> System.out.println("Btn Anterior"));

        JButton btnUltimo = new JButton("Último");
        btnUltimo.addActionListener(e -> System.out.println("Btn Último"));

        panelBtns.add(btnPrimero);
        panelBtns.add(btnSiguiente);
        panelBtns.add(btnAnterior);
        panelBtns.add(btnUltimo);

        add(panelBtns, BorderLayout.SOUTH);

        setVisible(true);
    }
}


package org.mdv.views;

import org.mdv.dao.EmpleadoDAO;
import org.mdv.model.Empleado;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class EmployedWindow extends JFrame {

    public EmployedWindow() throws SQLException {
        AtomicInteger currentId = new AtomicInteger(6);
        AtomicReference<Empleado> empleado = new AtomicReference<>(getEmpleadoId(currentId.get()));
        setTitle("Empleados");
        setSize(400, 300);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // titulo
        JPanel panelTitle = new JPanel();
        JLabel lblTitle = new JLabel("Gestión de Empleados");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        panelTitle.add(lblTitle);
        add(panelTitle, BorderLayout.NORTH);

        // Panel central con campos de texto
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(6, 2, 5, 5));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel emplIdLabel = new JLabel("ID Empleado:");
        JTextField emplIdField = new JTextField(String.valueOf(empleado.get().getId()));

        JLabel emplLastNameLabel = new JLabel("Apellido:");
        JTextField emplLastNameField = new JTextField(empleado.get().getApellido());

        JLabel jobLabel = new JLabel("Oficio:");
        JTextField jobField = new JTextField(empleado.get().getOficio());

        JLabel salaryLabel = new JLabel("Salario:");
        JTextField salaryField = new JTextField(String.valueOf(empleado.get().getSalario()));

        JLabel comisionLabel = new JLabel("Comisión:");
        JTextField comisionField = new JTextField(String.valueOf(empleado.get().getComision()));

        JLabel dateLabel = new JLabel("Fecha de alta:");
        JTextField dateField = new JTextField(empleado.get().getFechaAlta());

        panelCenter.add(emplIdLabel);
        panelCenter.add(emplIdField);
        panelCenter.add(emplLastNameLabel);
        panelCenter.add(emplLastNameField);
        panelCenter.add(jobLabel);
        panelCenter.add(jobField);
        panelCenter.add(salaryLabel);
        panelCenter.add(salaryField);
        panelCenter.add(comisionLabel);
        panelCenter.add(comisionField);
        panelCenter.add(dateLabel);
        panelCenter.add(dateField);
        add(panelCenter, BorderLayout.CENTER);

        // Botones inferiores
        JPanel panelBtns = new JPanel();
        panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnInsertar = new JButton("INSERTAR");
        btnInsertar.addActionListener(e -> System.out.println("Btn Insertar"));

        JButton btnNext = new JButton("SIGIUENTE");
        btnNext.addActionListener(e -> {
            try {
                currentId.getAndIncrement();
                empleado.set(getEmpleadoId(currentId.get()));
                emplIdField.setText(String.valueOf(empleado.get().getId()));
                emplLastNameField.setText(empleado.get().getApellido());
                jobField.setText(empleado.get().getOficio());
                salaryField.setText(String.valueOf(empleado.get().getSalario()));
                comisionField.setText(String.valueOf(empleado.get().getComision()));
                dateField.setText(empleado.get().getFechaAlta());
                System.out.println("Btn Siguiente" + currentId);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        JButton btnEliminar = new JButton("ELIMINAR");
        btnEliminar.addActionListener(e -> System.out.println("Btn Eliminar"));

        JButton btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.addActionListener(e -> System.out.println("Btn Actualizar"));

        JButton btnSalir = new JButton("SALIR");
        btnSalir.addActionListener(e -> dispose());

        JButton btnClear = new JButton("LIMPIAR");
        btnClear.addActionListener(e -> {
            emplIdField.setText("");
            emplLastNameField.setText("");
            jobField.setText("");
            salaryField.setText("");
            comisionField.setText("");
            dateField.setText("");
        });

        panelBtns.add(btnInsertar);
        panelBtns.add(btnNext);
        panelBtns.add(btnEliminar);
        panelBtns.add(btnActualizar);
        panelBtns.add(btnClear);
        panelBtns.add(btnSalir);
        add(panelBtns, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static Empleado getEmpleadoId(int id) throws SQLException {
        var dao = new EmpleadoDAO();

        return dao.getEmpleadoById(id);
    }
}
   
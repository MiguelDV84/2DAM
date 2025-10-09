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
        setSize(900, 450);

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
        emplIdField.setEditable(false);

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
        btnInsertar.addActionListener(e -> insertEmployed(empleado, emplLastNameField));

        JButton btnNext = new JButton("SIGIUENTE");
        btnNext.addActionListener(e -> {
          nextEmploeyed(currentId, empleado, emplIdField, emplLastNameField, jobField, salaryField, comisionField, dateField);
        });

        JButton btnEliminar = new JButton("ELIMINAR");
        btnEliminar.addActionListener(e -> System.out.println("Btn Eliminar"));

        JButton btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.addActionListener(e -> System.out.println("Btn Actualizar"));

        JButton btnSalir = new JButton("SALIR");
        btnSalir.addActionListener(e -> dispose());

        JButton btnClear = new JButton("LIMPIAR");
        btnClear.addActionListener(e -> {
            clearFields(emplIdField, emplLastNameField, jobField, salaryField, comisionField, dateField);
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

    public static void nextEmploeyed(AtomicInteger id, AtomicReference<Empleado> empleado, JTextField emplIdField, JTextField emplLastNameField, JTextField jobField, JTextField salaryField, JTextField comisionField, JTextField dateField) {
        try {
            id.getAndIncrement();
            empleado.set(getEmpleadoId(id.get()));
            emplIdField.setText(String.valueOf(empleado.get().getId()));
            emplLastNameField.setText(empleado.get().getApellido());
            jobField.setText(empleado.get().getOficio());
            salaryField.setText(String.valueOf(empleado.get().getSalario()));
            comisionField.setText(String.valueOf(empleado.get().getComision()));
            dateField.setText(empleado.get().getFechaAlta());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public static void insertEmployed(AtomicReference<Empleado> empleado, JTextField... otherFields) {
            var dao = new EmpleadoDAO();
            try {
                empleado.get().setApellido(otherFields[1].getText());
                empleado.get().setOficio(otherFields[2].getText());
                empleado.get().setSalario(Double.parseDouble(otherFields[3].getText()));
                empleado.get().setComision(Integer.parseInt(otherFields[4].getText()));
                empleado.get().setFechaAlta(otherFields[5].getText());
                System.out.println(empleado.get().getApellido());
                dao.insertEmpleado(empleado.get());
                JOptionPane.showMessageDialog(null,
                        "Empleado insertado con exito",
                        "Exito",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}
   
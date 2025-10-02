package org.mdv;

import org.mdv.dao.EmpleadoDAO;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
    var dao = new EmpleadoDAO();
        dao.getEmpleados().forEach(empleado -> System.out.println(empleado.getApellido()));
    }
}
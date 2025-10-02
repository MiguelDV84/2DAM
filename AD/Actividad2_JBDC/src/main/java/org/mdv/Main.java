package org.mdv;

import org.mdv.dao.EmpleadoDAO;
import org.mdv.model.Empleado;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
    var dao = new EmpleadoDAO();

    Empleado empleadoNuevo = new Empleado("Moranco","Risketo","Limpiadora","29/6/1989",26000,1000,1);
    dao.insertEmpleado(empleadoNuevo);
    dao.getEmpleados().forEach(empleado -> System.out.println(empleado.getApellido()));

    //Empleado empleadoById = dao.getEmpleadoById(4);
    //System.out.println(empleadoById.getNombre());
    }
}
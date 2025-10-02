package org.mdv.dao;

import org.mdv.model.Empleado;

import java.sql.SQLException;
import java.util.List;

public interface IEmpleadoDAO {
    List<Empleado> getEmpleados() throws SQLException;
    Empleado getEmpleadoById(int id) throws SQLException;
    Empleado getEmpleadoByLastName(String lastName);
    boolean insertEmpleado(Empleado empleado) throws SQLException;
    boolean updateEmpleado(Empleado empleado) throws SQLException;
    boolean deleteEmpleado(Empleado empleado);
}

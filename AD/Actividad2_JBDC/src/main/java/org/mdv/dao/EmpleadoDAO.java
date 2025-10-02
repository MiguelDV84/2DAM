package org.mdv.dao;

import org.mdv.conexion.Conexion;
import org.mdv.model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public List<Empleado> getEmpleados() throws SQLException {
        String sql = "SELECT * FROM empleados ORDER BY id_emp";
        try (Connection cn = Conexion.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            List<Empleado> out = new ArrayList<>();
            while(rs.next()) {
                out.add(new Empleado(rs.getInt("id_emp"),
                                     rs.getString("nombre"),
                                     rs.getString("apellido"),
                                     rs.getString("oficio"),
                                     rs.getString("fecha_alta"),
                                     rs.getInt("salario"),
                                     rs.getInt("comision"),
                                     rs.getInt("id_dep") ));
            }
            return out;
        }

    }
}

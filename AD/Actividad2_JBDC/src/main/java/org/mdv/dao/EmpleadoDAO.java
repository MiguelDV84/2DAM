package org.mdv.dao;

import org.mdv.model.Empleado;
import org.mdv.utils.ConexionHikari;
import org.mdv.utils.QueryCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoDAO implements IEmpleadoDAO {

    @Override
    public List<Empleado> getEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String sql = QueryCreator.queryCreator(QueryCreator.TYPE_QUERY.SELECT, "empleados");
        try (Connection cn = ConexionHikari.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                empleados.add(employedMapper(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }

    @Override
    public Empleado getEmpleadoById(int id) throws SQLException {
        Empleado empleado = new Empleado();
        String sql = QueryCreator.queryCreator(QueryCreator.TYPE_QUERY.SELECT_BYID,
                "empleados",
                "id_emp",
                String.valueOf(id));
        //printLn para mostrar la consulta en pantalla y comprobar que es correcta
        System.out.println(sql);

        try (Connection cn = ConexionHikari.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                empleado = employedMapper(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleado;
    }


    @Override
    public Empleado getEmpleadoByLastName(String lastName) {
        return null;
    }

    @Override
    public boolean insertEmpleado(Empleado empleado) throws SQLException {
        String sql = QueryCreator.queryCreator(QueryCreator.TYPE_QUERY.INSERT,
                "empleados",
                "nombre",
                "apellido",
                "oficio",
                "fecha_alta",
                "salario",
                "comision",
                "id_dep");

        try (Connection cn = ConexionHikari.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            employedPsMapper(ps, empleado);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateEmpleado(Empleado empleado) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteEmpleado(Empleado empleado) {
        return false;
    }

    public static void employedPsMapper(PreparedStatement ps, Empleado empleado) throws SQLException {
        ps.setInt(0, empleado.getId());
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellido());
        ps.setString(3, empleado.getOficio());
        ps.setString(4, empleado.getFechaAlta());
        ps.setDouble(5, empleado.getSalario());
        ps.setInt(6, empleado.getComision());
        ps.setInt(7, empleado.getIdDepartamento());
    }

    public static Empleado employedMapper(ResultSet rs) throws SQLException {
        return new Empleado(rs.getInt("id_emp"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("oficio"),
                rs.getString("fecha_alta"),
                rs.getInt("salario"),
                rs.getInt("comision"),
                rs.getInt("id_dep"));
    }
}

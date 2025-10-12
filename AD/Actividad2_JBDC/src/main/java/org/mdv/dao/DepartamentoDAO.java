package org.mdv.dao;

import org.mdv.model.Departamento;
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

public class DepartamentoDAO implements IDepartamentoDAO {

    @Override
    public List<Departamento> getDepartamentos() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = QueryCreator.queryCreator(QueryCreator.TYPE_QUERY.SELECT, "departamentos");
        try(Connection cn = ConexionHikari.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            while(rs.next()){
                departamentos.add(departamentoMapper(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return departamentos;
    }

    @Override
    public Departamento getDepartamentoById(int id) throws SQLException {
        Departamento departamento = new Departamento();
        String sql = QueryCreator.queryCreator(QueryCreator.TYPE_QUERY.SELECT_BYID, "departamentos", "id_dep", String.valueOf(id));
        System.out.println(sql);
        return getDepartamento(departamento, sql);
    }

    @Override
    public Departamento getDepartamentoByName(String name) throws SQLException {
        Departamento departamento = new Departamento();
        String sql = "SELECT * FROM departamentos WHERE nombre_dep = ?";
        return getDepartamento(departamento, sql);
    }



    @Override
    public boolean insertDepartamento(Departamento departamento) throws SQLException {
        String sql = QueryCreator.queryCreator(QueryCreator.TYPE_QUERY.INSERT,
                "departamentos",
                "nombre_dep",
                "localidad");
        System.out.println(sql);
        try (Connection cn = ConexionHikari.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            departamentoPsMapper(ps, departamento);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateDepartamento(Departamento departamento) throws SQLException {
        String sql = QueryCreator.queryCreator(QueryCreator.TYPE_QUERY.UPDATE,
                "departamentos",
                "nombre_dep",
                "localidad",
                "id_dep");

        System.out.println(sql);

        try (Connection cn = ConexionHikari.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            departamentoPsMapper(ps, departamento);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteDepartamento(Departamento departamento) throws SQLException {
        /*String sql = QueryCreator.queryCreator(QueryCreator.TYPE_QUERY.DELETE,
                "departamentos",
                "id_dep"); */

        String sql = "DELETE FROM departamentos WHERE id_dep = ?";

        System.out.println(sql);
        try (Connection cn = ConexionHikari.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, departamento.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            return false;
        }
    }

    private Departamento getDepartamento(Departamento departamento, String sql) {
        try (Connection cn = ConexionHikari.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();) {
            if(rs.next()) {
                departamento = departamentoMapper(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamento;
    }

    public static Departamento departamentoMapper(ResultSet rs) throws SQLException {
        return new Departamento(rs.getInt("id_dep"),
                rs.getString("nombre_dep"),
                rs.getString("localidad"));
    }

    public static void departamentoPsMapper(PreparedStatement ps, Departamento departamento) throws SQLException {
        ps.setString(1, departamento.getNombreDep());
        ps.setString(2, departamento.getLocalidad());
    }
}

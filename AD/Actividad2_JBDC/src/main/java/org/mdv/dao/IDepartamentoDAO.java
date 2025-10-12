package org.mdv.dao;

import org.mdv.model.Departamento;

import java.sql.SQLException;
import java.util.List;

public interface IDepartamentoDAO {
    List<Departamento> getDepartamentos() throws SQLException;
    Departamento getDepartamentoById(int id) throws SQLException;
    Departamento getDepartamentoByName(String name) throws SQLException;
    boolean insertDepartamento(Departamento departamento) throws SQLException;
    boolean updateDepartamento(Departamento departamento) throws SQLException;
    boolean deleteDepartamento(Departamento departamento) throws SQLException;
}

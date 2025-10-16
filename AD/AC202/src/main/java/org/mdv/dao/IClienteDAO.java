package org.mdv.dao;

import org.mdv.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {
    List<Cliente> getClientes() throws SQLException;
    Cliente getClienteByDni(String dni) throws SQLException;
    Cliente getClienteByNombre(String nombre) throws SQLException;
    boolean insertCliente(Cliente cliente) throws SQLException;
    boolean updateCliente(Cliente cliente) throws SQLException;
    boolean deleteCliente(Cliente cliente) throws SQLException;
}

package org.mdv.utils;

import org.mdv.model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteMapper {

    public static Cliente clienteRsMapper(ResultSet rs) throws SQLException {
        return new Cliente(rs.getString("dni"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getInt("telefono"),
                rs.getString("dir_habitual"),
                rs.getString("dir_envio"));
    }
}

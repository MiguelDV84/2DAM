package org.mdv.dao;

import org.mdv.model.Cliente;
import org.mdv.utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.mdv.utils.ClienteMapper.clienteRsMapper;

public class ClienteDAO implements IClienteDAO {
    private final Connection cn = Conexion.getConnection();

    public ClienteDAO() throws SQLException {
    }

    @Override
    public List<Cliente> getClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (cn;
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
               Cliente cliente = clienteRsMapper(rs);
               clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cn.close();
        }
        return clientes;
    }

    @Override
    public Cliente getClienteByDni(String dni) throws SQLException {
        Cliente nuevoCliente = new Cliente();
        String sql = "SELECT * FROM clientes WHERE dni = ?";
        try (cn;
             PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nuevoCliente.setDni(rs.getString("dni"));
                    nuevoCliente.setNombre(rs.getString("nombre"));
                    nuevoCliente.setApellidos(rs.getString("apellidos"));
                    nuevoCliente.setDirHabitual(rs.getString("dir_habitual"));
                    nuevoCliente.setDirEnvio(rs.getString("dir_envio"));
                    nuevoCliente.setTelefono(rs.getInt("telefono"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName());
        } finally {
            cn.close();
        }

        return nuevoCliente;
    }

    @Override
    public Cliente getClienteByNombre(String nombre) throws SQLException {
        Cliente nuevoCliente = new Cliente();
        String sql = "SELECT * FROM clientes WHERE nombre = ?";
        try (cn;
             PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nuevoCliente.setDni(rs.getString("dni"));
                    nuevoCliente.setNombre(rs.getString("nombre"));
                    nuevoCliente.setApellidos(rs.getString("apellidos"));
                    nuevoCliente.setDirHabitual(rs.getString("dir_habitual"));
                    nuevoCliente.setDirEnvio(rs.getString("dir_envio"));
                    nuevoCliente.setTelefono(rs.getInt("telefono"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName());
        } finally {
            cn.close();
        }

        return nuevoCliente;
    }

    @Override
    public boolean insertCliente(Cliente cliente) throws SQLException {
       String sql = "INSERT INTO clientes (dni, nombre, apellidos, telefono, dir_habitual, dir_envio) VALUES (?, ?, ?, ?, ?, ?)";
       try (cn;
            PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setString(1, cliente.getDni());
                ps.setString(2, cliente.getNombre());
                ps.setString(3, cliente.getApellidos());
                ps.setInt(4, cliente.getTelefono());
                ps.setString(5, cliente.getDirHabitual());
                ps.setString(6, cliente.getDirEnvio());
              return ps.executeUpdate() > 0;
       } catch (SQLException e) {
           System.err.println("❌ ERROR: " + e.getMessage());
           return false;
       } finally {
              cn.close();
       }
    }

    @Override
    public boolean updateCliente(Cliente cliente) throws SQLException {
        Cliente clienteActualizado = new Cliente();
        String sql = "UPDATE clientes SET nombre = ?, apellidos = ?, telefono = ?, dir_habitual = ?, dir_envio = ? WHERE dni = ?";
        try (cn;
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setInt(4, cliente.getTelefono());
            ps.setString(5, cliente.getDirHabitual());
            ps.setString(6, cliente.getDirEnvio());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            return false;
        } finally {
            cn.close();
        }
    }

    @Override
    public boolean deleteCliente(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM clientes WHERE dni = ?";
        try (cn;
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cliente.getDni());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            return false;
        } finally {
            cn.close();
        }
    }
}

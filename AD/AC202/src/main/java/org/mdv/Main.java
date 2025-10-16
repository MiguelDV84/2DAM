package org.mdv;


import org.mdv.dao.ClienteDAO;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
       var clienteDAO = new ClienteDAO();
         clienteDAO.getClientes().forEach(cliente -> {
            System.out.println(cliente.toString());
         });

    }
}
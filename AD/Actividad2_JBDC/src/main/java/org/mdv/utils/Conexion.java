package org.mdv.utils;

import java.sql.*;

public class Conexion {
    private static final String URLlinux = "jdbc:sqlite:/home/usumaniana/Escritorio/MiguelDV84/2DAM/AD/Actividad2_JBDC/Actividad2_JBDC.db";
    private static final String URLWindows = "jdbc:sqlite:C:\\Users\\migue\\Documents\\2DAM\\1Trimestre\\2DAM\\AD\\Actividad2_JBDC\\Actividad2_JBDC.db";


    public static Connection getConnection() throws SQLException{
        Connection cn = DriverManager.getConnection(URLlinux);
        try (var st = cn.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
    return cn;
    }

    public static void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada");
            } catch(SQLException e) {
                System.out.println("Error al cerrar la conexión" + e.getMessage());
            }
        }
    }
}

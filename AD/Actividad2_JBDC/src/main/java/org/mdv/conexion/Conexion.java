package org.mdv.conexion;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:sqlite:/home/usumaniana/Escritorio/MiguelDV84/2DAM/AD/Actividad2_JBDC/Actividad2_JBDC.db";

    public static Connection getConnection() throws SQLException{
        Connection cn = DriverManager.getConnection(URL);
        try (var st = cn.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
    return cn;
    }
}

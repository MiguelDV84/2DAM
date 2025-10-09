package org.mdv.utils;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionHikari {
    private static final HikariDataSource DATA_SOURCE;
    private static final String URL_LINUX = "jdbc:sqlite:/home/usumaniana/Escritorio/MiguelDV84/2DAM/AD/Actividad2_JBDC/Actividad2_JBDC.db";
    private static final String URL_WINDOWS = "jdbc:sqlite:C:\\Users\\migue\\Documents\\2DAM\\1Trimestre\\2DAM\\AD\\Actividad2_JBDC\\Actividad2_JBDC.db";

    static {
        DATA_SOURCE = new HikariDataSource();
        DATA_SOURCE.setJdbcUrl(URL_LINUX);
        DATA_SOURCE.setMaximumPoolSize(10);
        DATA_SOURCE.setMinimumIdle(2);
        DATA_SOURCE.setIdleTimeout(30000);
        DATA_SOURCE.setConnectionTimeout(30000);
        DATA_SOURCE.setMaxLifetime(1800000);
    }

    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }

    public void close() {
        if (DATA_SOURCE != null) {
            DATA_SOURCE.close();
        }
    }
}

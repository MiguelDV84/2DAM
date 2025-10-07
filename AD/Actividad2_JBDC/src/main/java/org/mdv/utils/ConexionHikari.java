package org.mdv.utils;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionHikari {
    private static HikariDataSource dataSource;
    private static String urlLinux = "jdbc:sqlite:/home/usumaniana/Escritorio/MiguelDV84/2DAM/AD/Actividad2_JBDC/Actividad2_JBDC.db";
    private static String urlWindows = "jdbc:sqlite:C:\\Users\\migue\\Documents\\2DAM\\1Trimestre\\2DAM\\AD\\Actividad2_JBDC\\Actividad2_JBDC.db";

    static {
        dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(urlLinux);
        dataSource.setMaximumPoolSize(10);
        dataSource.setMinimumIdle(2);
        dataSource.setIdleTimeout(30000);
        dataSource.setConnectionTimeout(30000);
        dataSource.setMaxLifetime(1800000);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}

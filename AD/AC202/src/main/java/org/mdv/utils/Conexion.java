package org.mdv.utils;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {
    private static final HikariDataSource DATA_SOURCE;
    private static final String URL = "jdbc:mariadb://192.168.21.248:3306/gestion-ventas";

    static {
        DATA_SOURCE = new HikariDataSource();
        DATA_SOURCE.setUsername("root");
        DATA_SOURCE.setPassword("root");
        DATA_SOURCE.setJdbcUrl(URL);
        DATA_SOURCE.setMaximumPoolSize(10);
        DATA_SOURCE.setMinimumIdle(2);
        DATA_SOURCE.setIdleTimeout(30000);
        DATA_SOURCE.setConnectionTimeout(30000);
        DATA_SOURCE.setMaxLifetime(1800000);
    }

    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }

    public static void close() {
        if (DATA_SOURCE != null) {
            DATA_SOURCE.close();
        }
    }
}

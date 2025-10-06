package org.mdv.utils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;

public class QueryCreator {
    public enum TYPE_QUERY {
        INSERT,
        UPDATE,
        DELETE,
        SELECT,
        SELECT_BYID
    }

    public static String queryCreator(TYPE_QUERY tipoQuery, String table, String... columns) throws SQLException {
        StringBuilder sql = new StringBuilder();
        switch (tipoQuery) {
            case SELECT:
                return String.format("SELECT %s FROM %s", String.join(", ", columns), table);
                // return sql.append("SELECT * FROM ").append(table).toString();
            case SELECT_BYID:
                return sql.append("SELECT * FROM ").append(table).append(" WHERE ").append(columns[0]).append("=").append(columns[1]).toString();
            case INSERT:
                if(columns==null || columns.length==0){
                    throw new SQLException("Se requiere columnas");
                }

                String[] columnNamesInsert = Arrays.stream(columns).map(Object::toString).toArray(String[]::new);
                sql.append("INSERT INTO ")
                        .append(table)
                        .append(" (")
                        .append(String.join(", ", columnNamesInsert))
                        .append(") VALUES (");

                String placeHolder = String.join(", ",
                                                Collections.nCopies(columns.length, "?"));
                sql.append(placeHolder).append(")");

                return sql.toString();
            case UPDATE:
                if(columns==null || columns.length==0){
                    throw new SQLException("Se requiere columnas");
                }

                String[] columnNames = Arrays.stream(columns).map(Object::toString).toArray(String[]::new);
                sql.append("UPDATE ")
                        .append(table)
                        .append(" SET ")
                        .append(String.join(", ", columnNames))
                        .append(" WHERE ")
                        .append(String.join(", ", columnNames))
                        .append(" = ?");

            default:
                throw new SQLException("Tipo de query invalido");
        }
    }
}

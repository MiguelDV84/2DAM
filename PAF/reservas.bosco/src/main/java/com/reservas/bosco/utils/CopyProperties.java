package com.reservas.bosco.utils;

import java.lang.reflect.InvocationTargetException;

public class CopyProperties {

    private static final ClassUtil classUtil = new ClassUtil();

    public static void copyProperties(Object source, Object origin) {
        try {
            classUtil.copyProperties(source, origin);
        } catch (IllegalAccessException e) {
            System.out.println("Error de acceso al copiar las propiedades: " + e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println("Error al invocar el método para copiar las propiedades: " + e.getMessage());
        }
    }
}

package org.mdv;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class TestCuentaBancaria {

    public static void main(String[] args) throws Exception {
        // 1) Verifica que exista cuentas.txt en el directorio de trabajo del proyecto.
        Path in = Paths.get("cuentas.txt");
        if (!Files.exists(in)) {
            // Opcional: crear un ejemplo mínimo (ajusta/borra si ya tienes tu fichero)
            List<String> ejemplo = List.of(
                    "2100 0418 45 0200051332", // ejemplo (puede ser válida/invalidar según DC real)
                    "1234-5678-00-1234567890",
                    "ES12 3456 7890 12 1234567890", // con prefijo, se ignorarán no dígitos
                    "NULL" // el CheckCuentaBancaria dejará de leer aquí
            );
            Files.write(in, ejemplo, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
            System.out.println("Se ha creado un ejemplo de cuentas.txt (ajústalo con tus cuentas válidas/erróneas).");
        }

        // 2) Construye el comando para lanzar el subproceso CheckCuentaBancaria
        String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String mainClass = "es.iesjuanbosco.psp.ut1.CheckCuentaBancaria";

        ProcessBuilder pb = new ProcessBuilder(javaBin, "-cp", classpath, mainClass);

        // 3) Redirecciones: stdin desde cuentas.txt, stdout a resultado.txt, stderr a la consola
        File cuentas = in.toFile();
        File resultado = Paths.get("resultado.txt").toFile();

        pb.redirectInput(cuentas);
        pb.redirectOutput(ProcessBuilder.Redirect.to(resultado));
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);

        // 4) Lanzar y esperar fin
        Process p = pb.start();
        int exitCode = p.waitFor();

        // 5) Mostrar por stdout el contenido de resultado.txt (independientemente del exit code)
        if (resultado.exists()) {
            System.out.println("=== Contenido de resultado.txt ===");
            Files.lines(resultado.toPath(), StandardCharsets.UTF_8).forEach(System.out::println);
        } else {
            System.err.println("No se ha generado resultado.txt");
        }

        // Código de salida informativo
        if (exitCode != 0) {
            System.err.println("El subproceso terminó con código " + exitCode);
        }
    }
}
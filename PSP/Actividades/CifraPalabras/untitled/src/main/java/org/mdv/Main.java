package org.mdv;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        cifraPalabras("deja de espiarme");

    }
    public static void cifraPalabras(String mensaje){
        StringBuilder palabraCifrada = new StringBuilder();
        String[] palabras = mensaje.split(" ");
        for (String palabra : palabras) {
            StringBuilder pares = new StringBuilder();
            StringBuilder impares = new StringBuilder();
            for (int j = 0; j < palabra.length(); j++) {
                if( j % 2 == 0) {
                    pares.append(palabra.charAt(j));
                } else {
                    impares.append(palabra.charAt(j));

                }
            }

            palabraCifrada.append(pares).append(impares).append(" ");
        }
       System.out.println(palabraCifrada.toString().trim());

    }

}
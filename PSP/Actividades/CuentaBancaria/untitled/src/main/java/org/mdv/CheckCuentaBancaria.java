package org.mdv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckCuentaBancaria {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, java.nio.charset.StandardCharsets.UTF_8));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equalsIgnoreCase("NULL")) break;
            if (line.isEmpty()) continue;

            String original = line;
            String digits = line.replaceAll("\\D", ""); // quitar separadores

            if (digits.length() != 20) {
                System.out.println(original + " -> INCORRECTA");
                continue;
            }

            String entidad  = digits.substring(0, 4);
            String sucursal = digits.substring(4, 8);
            String dc       = digits.substring(8, 10);
            String cuenta   = digits.substring(10, 20);

            int dc1Calc = calculaDCEntidadSucursal(entidad + sucursal);
            int dc2Calc = calculaDCCuenta(cuenta);

            boolean ok = (dc.charAt(0) - '0') == dc1Calc && (dc.charAt(1) - '0') == dc2Calc;

            System.out.println(original + " -> " + (ok ? "VÁLIDA" : "INCORRECTA"));
        }
    }

    static int calculaDCEntidadSucursal(String ochoDigitos) {
        int[] pesos = {4, 8, 5, 10, 9, 7, 3, 6};
        return calculaDC(ochoDigitos, pesos);
    }

    static int calculaDCCuenta(String diezDigitos) {
        int[] pesos = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
        return calculaDC(diezDigitos, pesos);
    }

    private static int calculaDC(String numeros, int[] pesos) {
        long suma = 0;
        for (int i = 0; i < pesos.length; i++) {
            int d = numeros.charAt(i) - '0';
            suma += d * pesos[i];
        }
        int dc = 11 - (int)(suma % 11);
        if (dc == 10) return 1;
        if (dc == 11) return 0;
        return dc;
    }
}
package org.mdv.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecautoCSVReader {
    private String filePath;
    BufferedReader reader;

    public RecautoCSVReader(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.reader = new BufferedReader(new FileReader(filePath));
    }

    private List<Recauto> leerCSV() throws IOException {
        List<Recauto> listaRecauto= new ArrayList<>();
        String line = null;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            String[] lineContents = line.split(",");
            Recauto recauto = new Recauto();
            recauto.setId(Integer.parseInt(lineContents[0]));
            recauto.setPropietario(lineContents[1]);
            recauto.setMatricula(lineContents[2]);
            recauto.setAnterior2000(lineContents[3]);
            recauto.setMotivo(lineContents[4]);
            recauto.setFechaTaller(lineContents[5]);
            recauto.setFechaAlta(lineContents[6]);
            recauto.setEstado(false);
            listaRecauto.add(recauto);
            count++;

        }
        return listaRecauto;
    }

}

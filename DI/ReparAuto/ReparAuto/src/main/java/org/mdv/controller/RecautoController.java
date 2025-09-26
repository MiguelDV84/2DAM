package org.mdv.controller;

import org.mdv.model.RecautoCSVReader;

import java.io.File;
import java.io.FileNotFoundException;

public class RecautoController {
    private final String FILE_PATH = ".." + File.separator + "RECAUTO.csv";
    private RecautoCSVReader reader = new RecautoCSVReader(FILE_PATH);

    public RecautoController() throws FileNotFoundException {
    }

    private void mostrarLista(){

    }
}

package org.academiadecodigo.gnunas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadFile {
    private final String filePath;

    public ReadFile(String filePath) {
        this.filePath = filePath;
    }

    public FileInputStream readFile() throws FileNotFoundException {

        return new FileInputStream(filePath);
    }
}

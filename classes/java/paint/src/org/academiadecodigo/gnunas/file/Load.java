package org.academiadecodigo.gnunas.file;

import java.io.*;
import java.util.LinkedList;

public class Load {
    public static LinkedList<Boolean> load() {
        BufferedReader bufferedReader = null;
        LinkedList<Boolean> loadedTiles = null;

        try {
            FileReader file = new FileReader("test.draw");
            bufferedReader = new BufferedReader(file);

            String line;

            loadedTiles = new LinkedList<>();

            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                if (line.contains("false")) {
                    loadedTiles.add(false);
                    continue;
                }

                loadedTiles.add(true);
            }
        } catch (IOException e) {
            e.printStackTrace();

            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException t) {
                t.printStackTrace();
            }
        }

        return loadedTiles;
    }
}

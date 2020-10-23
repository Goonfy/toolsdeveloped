package org.academiadecodigo.gnunas.file;

import org.academiadecodigo.gnunas.cell.Cell;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FileManager {
    public static void save(LinkedList<Cell> gridPositions) {
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream("test.draw");

            for (int i = 0; i < gridPositions.size(); i++) {
                if (!gridPositions.get(i).isFilled()) {
                    continue;
                }

                String line = gridPositions.get(i).toString() + "\n";
                outputStream.write(line.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException t) {
                t.printStackTrace();
            }
        }
    }

    public static LinkedList<Integer> load() {
        BufferedReader bufferedReader = null;
        LinkedList<Integer> loadedTiles = null;

        try {
            FileReader file = new FileReader("test.draw");
            bufferedReader = new BufferedReader(file);

            String line;

            loadedTiles = new LinkedList<>();

            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                loadedTiles.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

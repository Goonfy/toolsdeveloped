package org.academiadecodigo.gnunas.file;

import org.academiadecodigo.gnunas.cell.Cell;

import java.io.*;
import java.util.LinkedList;

public class Save {
    public static void save(LinkedList<Cell> gridPositions) {
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream("test.draw");

            for (int i = 0; i < gridPositions.size(); i++) {
                String line = gridPositions.get(i).toString() + "\n";
                outputStream.write(line.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();

            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException t) {
                t.printStackTrace();
            }
        }
    }
}

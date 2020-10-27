package org.academiadecodigo.gnunas.cell;

import org.academiadecodigo.gnunas.Paint;

public class CellFactory {
    private static int cellID;

    public static Cell makeCell(int posX, int posY) {
        System.out.println(cellID);
        return new Cell(posX + Paint.PADDING, posY + Paint.PADDING, Paint.getCellSize(), Paint.getCellSize(), cellID++, false);
    }
}

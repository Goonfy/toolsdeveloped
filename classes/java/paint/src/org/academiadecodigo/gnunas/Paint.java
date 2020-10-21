package org.academiadecodigo.gnunas;

import org.academiadecodigo.gnunas.cell.Cell;
import org.academiadecodigo.gnunas.file.Load;
import org.academiadecodigo.gnunas.file.Save;
import org.academiadecodigo.gnunas.input.Keyboard;
import org.academiadecodigo.gnunas.tools.Brush;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class Paint {

    private static Rectangle screen;

    private final Brush brush;

    public static final int PADDING = 10;

    public static final int CELLSIZE = 30;

    public static final int NUMBEROFCOLS = 8;
    public static final int NUMBEROFROWS = 8;

    private static final LinkedList<Cell> gridPositions = new LinkedList<>();

    public Paint() {
        drawScreen();

        brush = new Brush(gridPositions);

        new Keyboard(brush);
    }

    private void drawScreen() {
        screen = new Rectangle(PADDING, PADDING, CELLSIZE * NUMBEROFCOLS, CELLSIZE * NUMBEROFROWS);
        screen.draw();

        int posX = 0;
        int posY = 0;

        for (int c = 0; c < NUMBEROFCOLS; c++) {
            for (int r = 0; r < NUMBEROFROWS; r++) {
                Cell gridRectangle = new Cell(posX + PADDING, posY + PADDING, CELLSIZE, CELLSIZE, false);
                gridRectangle.draw();

                gridPositions.add(gridRectangle);

                posY += CELLSIZE;
            }

            posY = 0;
            posX += CELLSIZE;
        }
    }

    public static void clean() {
        for (int i = 0; i < gridPositions.size(); i++) {
            Cell gridCell = gridPositions.get(i);
            gridCell.draw();
            gridCell.setFilled(false);
        }
    }

    public static void loadDraw() {
        for (int i = 0; i < gridPositions.size(); i++) {
            Cell gridCell = gridPositions.get(i);

            LinkedList<Boolean> savedTiles = Load.load();

            if (savedTiles == null) {
                return;
            }

            if (savedTiles.get(i)) {
                gridCell.fill();
                gridCell.setColor(Color.DARK_GRAY);
                gridCell.setFilled(true);
            }
        }
    }

    public static void saveDraw() {
        Save.save(gridPositions);
    }

    public static int getWidth() {
        return screen.getWidth();
    }

    public static int getHeight() {
        return screen.getHeight();
    }
}

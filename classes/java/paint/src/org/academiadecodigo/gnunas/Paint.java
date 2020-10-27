package org.academiadecodigo.gnunas;

import org.academiadecodigo.gnunas.cell.Cell;
import org.academiadecodigo.gnunas.cell.CellFactory;
import org.academiadecodigo.gnunas.file.FileManager;
import org.academiadecodigo.gnunas.input.Keyboard;
import org.academiadecodigo.gnunas.tools.Brush;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class Paint {

    public static final int PADDING = 10;

    private static Rectangle screen;

    private static int NUMBER_OF_COLS;
    private static int NUMBER_OF_ROWS;
    private static int CELL_SIZE;

    private static final LinkedList<Cell> gridPositions = new LinkedList<>();

    public Paint(int numberOfCols, int numberOfRows, int cellSize) {
        NUMBER_OF_COLS = numberOfCols;
        NUMBER_OF_ROWS = numberOfRows;
        CELL_SIZE = cellSize;
    }

    public void init() {
        screen = new Rectangle(PADDING, PADDING, CELL_SIZE * NUMBER_OF_COLS, CELL_SIZE * NUMBER_OF_COLS);
        screen.draw();

        makeGrid();

        Brush brush = new Brush(gridPositions);

        new Keyboard(brush);
    }

    public void makeGrid() {
        int posX = 0;
        int posY = 0;

        for (int colNumber = 0; colNumber <= NUMBER_OF_COLS; colNumber++) {
            for (int rowNumber = 0; rowNumber <= NUMBER_OF_ROWS; rowNumber++) {
                Cell cell = CellFactory.makeCell(posX, posY);
                cell.draw();

                gridPositions.add(cell);

                posY += CELL_SIZE;
            }

            posY = 0;
            posX += CELL_SIZE;
        }
    }

    public static void clean() {
        for (int i = 0; i < gridPositions.size(); i++) {
            Cell gridCell = gridPositions.get(i);
            gridCell.draw();
        }
    }

    public static void loadDraw() {
        for (int i = 0; i < gridPositions.size(); i++) {
            Cell gridCell = gridPositions.get(i);

            LinkedList<Integer> savedTiles = FileManager.load();

            if (savedTiles == null) {
                return;
            }

            if (savedTiles.contains(i)) {
                gridCell.fill();
            }
        }
    }

    public static void saveDraw() {
        FileManager.save(gridPositions);
    }

    public static int getNumberOfCols() {
        return NUMBER_OF_COLS;
    }

    public static int getNumberOfRows() {
        return NUMBER_OF_ROWS;
    }

    public static int getCellSize() {
        return CELL_SIZE;
    }

    public static int getWidth() {
        return screen.getWidth();
    }

    public static int getHeight() {
        return screen.getHeight();
    }
}

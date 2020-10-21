package org.academiadecodigo.gnunas.tools;

import org.academiadecodigo.gnunas.Paint;
import org.academiadecodigo.gnunas.cell.Cell;
import org.academiadecodigo.gnunas.input.KeysType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class Brush {
    private final Rectangle brushCursor;

    private final LinkedList<Cell> gridPositions;

    private boolean drawing;

    public Brush(LinkedList<Cell> gridPositions) {
        this.gridPositions = gridPositions;

        brushCursor = new Rectangle(Paint.PADDING, Paint.PADDING, Paint.CELLSIZE, Paint.CELLSIZE);
        brushCursor.fill();
        brushCursor.setColor(Color.GREEN);
    }

    public void draw() {
        for (int i = 0; i < gridPositions.size(); i++) {
            Cell gridCell = gridPositions.get(i);

            if (brushCursor.getX() != gridCell.getX() || brushCursor.getY() != gridCell.getY()) {
                continue;
            }

            if (gridCell.isFilled()) {
                gridCell.draw();
                gridCell.setFilled(false);

                return;
            }

            gridCell.fill();
            gridCell.setColor(Color.DARK_GRAY);
            gridCell.setFilled(true);

            return;
        }
    }

    public void move(KeysType keysType) {

        if (getX() + getWidth() >= Paint.getWidth() && keysType == KeysType.RIGHT) {
            return;
        }
        if (getX() <= Paint.PADDING && keysType == KeysType.LEFT) {
            return;
        }
        if (getY() + getHeight() >= Paint.getHeight() && keysType == KeysType.DOWN) {
            return;
        }
        if (getY() <= Paint.PADDING && keysType == KeysType.UP) {
            return;
        }

        int x = 0;
        int y = 0;

        switch (keysType) {
            case UP:
                y = -Paint.CELLSIZE;
                break;
            case DOWN:
                y = Paint.CELLSIZE;
                break;
            case LEFT:
                x = -Paint.CELLSIZE;
                break;
            case RIGHT:
                x = Paint.CELLSIZE;
                break;
            default:
                break;
        }

        brushCursor.translate(x, y);

        if (isDrawing()) {
            draw();
        }
    }

    public int getX() {
        return brushCursor.getX();
    }

    public int getY() {
        return brushCursor.getY();
    }

    public int getWidth() {
        return brushCursor.getWidth();
    }

    public int getHeight() {
        return brushCursor.getHeight();
    }

    public boolean isDrawing() {
        return drawing;
    }

    public void setDrawing(boolean drawing) {
        this.drawing = drawing;
    }
}

package org.academiadecodigo.gnunas.tools;

import org.academiadecodigo.gnunas.Paint;
import org.academiadecodigo.gnunas.cell.Cell;
import org.academiadecodigo.gnunas.input.KeyType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;
import java.util.Random;

public class Brush {
    private final Rectangle brushCursor;

    private final LinkedList<Cell> gridPositions;

    private boolean drawing;

    public Brush(LinkedList<Cell> gridPositions) {
        this.gridPositions = gridPositions;

        brushCursor = new Rectangle(Paint.PADDING, Paint.PADDING, Paint.getCellSize(), Paint.getCellSize());
        brushCursor.fill();
        brushCursor.setColor(Color.BLACK);
    }

    public void draw() {
        for (int i = 0; i < gridPositions.size(); i++) {
            Cell gridCell = gridPositions.get(i);

            if (brushCursor.getX() != gridCell.getX() || brushCursor.getY() != gridCell.getY()) {
                continue;
            }

            if (gridCell.isFilled()) {
                gridCell.draw();

                return;
            }

            gridCell.fill();

            return;
        }
    }

    public void move(KeyType keyType) {
        if (getX() + getWidth() >= Paint.getWidth() && keyType == KeyType.RIGHT) {
            return;
        }
        if (getX() <= Paint.PADDING && keyType == KeyType.LEFT) {
            return;
        }
        if (getY() + getHeight() >= Paint.getHeight() && keyType == KeyType.DOWN) {
            return;
        }
        if (getY() <= Paint.PADDING && keyType == KeyType.UP) {
            return;
        }

        int x = 0;
        int y = 0;

        switch (keyType) {
            case UP:
                y = -Paint.getCellSize();
                break;
            case DOWN:
                y = Paint.getCellSize();
                break;
            case LEFT:
                x = -Paint.getCellSize();
                break;
            case RIGHT:
                x = Paint.getCellSize();
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

package org.academiadecodigo.gnunas.cell;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.Random;

public class Cell extends Rectangle {
    private final int cellID;

    private Color color;

    private boolean filled;

    public Cell(double v, double v1, double v2, double v3, int cellID, boolean filled) {
        super(v, v1, v2, v3);

        this.filled = filled;

        this.cellID = cellID;
    }

    @Override
    public void draw() {
        super.draw();

        filled = false;
    }

    @Override
    public void delete() {
        super.delete();

        filled = false;
    }

    @Override
    public void fill() {
        super.fill();

        setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));

        filled = true;
    }

    public int getCellID() {
        return cellID;
    }

    public boolean isFilled() {
        return filled;
    }

    @Override
    public String toString() {
        return String.valueOf(cellID);
    }
}

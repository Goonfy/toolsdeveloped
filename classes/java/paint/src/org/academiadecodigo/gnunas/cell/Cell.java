package org.academiadecodigo.gnunas.cell;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell extends Rectangle {
    private boolean filled;

    public Cell(double v, double v1, double v2, double v3, boolean filled) {
        super(v, v1, v2, v3);

        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return String.valueOf(filled);
    }
}

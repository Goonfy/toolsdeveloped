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

        setColor(Color.BLACK);
    }

    public void draw() {
        super.draw();

        color = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue());
        setColor(color);

        filled = false;
    }
    
    public void fill() {
        super.fill();

        color = new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
        setColor(color);

        filled = true;
    }

    public int getCellID() {
        return cellID;
    }

    public Color getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    @Override
    public String toString() {
        return "id: " + cellID + " color: " + color.getRed() + " " + color.getGreen() + " " + color.getBlue();
    }
}

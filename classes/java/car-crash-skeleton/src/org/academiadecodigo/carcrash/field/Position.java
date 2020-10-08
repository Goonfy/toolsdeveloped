package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.cars.InputType;

public class Position {
    private int col;
    private int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void updatePosition(InputType inputType) {
        if (inputType == null) {
            return;
        }

        col += inputType.getCol();
        row += inputType.getRow();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}

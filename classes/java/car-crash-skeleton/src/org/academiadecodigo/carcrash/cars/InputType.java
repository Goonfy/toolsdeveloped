package org.academiadecodigo.carcrash.cars;

public enum InputType {
    FORWARD(1, 0),
    BACKWARDS(-1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private final int col;
    private final int row;

    InputType(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}

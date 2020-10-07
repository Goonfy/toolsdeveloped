package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public abstract class Car {
    private final Position pos;

    private boolean isCrashed;

    private boolean reverseForward;
    private boolean reverseTurn;

    protected int speed;

    protected int randomPercentage;

    protected String carBrand;

    public Car(int col, int row) {
        pos = new Position(col, row);

        reverseForward = false;
        reverseTurn = false;
    }

    public void moveCar() {
        if (isCrashed()) {
            return;
        }

        if ((int)(Math.random() * randomPercentage) == 0) {
            turn();
            return;
        }

        forward();
    }

    private void forward() {
        reverseTurn = (int)(Math.random() * 2) == 0;

        int col = reverseForward ? getPos().getCol() - speed : getPos().getCol() + speed;

        if (getPos().getCol() > Field.getWidth() - 1) {
            col = 0;
        }
        else if (getPos().getCol() < 0) {
            col = Field.getWidth() - 1;
        }

        getPos().setCol(col);
    }

    private void turn() {
        reverseForward = (int)(Math.random() * 2) == 0;

        int row = reverseTurn ? getPos().getRow() - speed : getPos().getRow() + speed;

        if (getPos().getRow() > Field.getHeight() - 1) {
            row = 0;
        }
        else if (getPos().getRow() < 0) {
            row = Field.getHeight() - 1;
        }

        getPos().setRow(row);
    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return isCrashed;
    }

    public void crash() {
        isCrashed = true;
        carBrand = "X";
    }
}

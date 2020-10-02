package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public abstract class Car {

    /** The position of the car on the grid */
    private Position pos;

    private boolean reverseAcceleration;
    private boolean reverseTurn;
    private boolean isCrashed;

    private final int SPEED;

    public Car(int col, int row) {
        pos = new Position(col, row);

        SPEED = 1;
    }

    public void moveCar() {
        if (getPos().getCol() >= Field.getWidth() - 1) {
            getPos().setCol(Field.getWidth() - 1);
            reverseAcceleration = true;
        }
        else if (getPos().getCol() <= 0) {
            getPos().setCol(0);
            reverseAcceleration = false;
        }

        if (getPos().getRow() >= Field.getHeight() - 1) {
            getPos().setRow(Field.getHeight() - 1);
            reverseTurn = true;
        }
        else if (getPos().getRow() <= 0) {
            getPos().setRow(0);
            reverseTurn = false;
        }

        if ((int)(Math.random() * 20) == 0) {
            turn();
            return;
        }

        accelerate();
    }

    private void accelerate() {
        reverseTurn = (int)(Math.random() * 2) == 0;
        int speed = reverseAcceleration ? getPos().getCol() - SPEED : getPos().getCol() + SPEED;
        getPos().setCol(speed);
    }

    private void turn() {
        reverseAcceleration = (int)(Math.random() * 2) == 0;
        int speed = reverseTurn ? getPos().getRow() - SPEED : getPos().getRow() + SPEED;
        getPos().setRow(speed);
    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return isCrashed;
    }

    private void checkCollision() {

    }
}

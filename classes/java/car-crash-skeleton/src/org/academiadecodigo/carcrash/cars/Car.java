package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public abstract class Car {
    private final Position position;

    private boolean crashed;

    private InputType inputType;

    protected int speed;

    public Car(Position position) {
        this.position = position;

        speed = 1;

        inputType = InputType.values()[(int)(Math.random() * InputType.values().length)];
    }

    public void moveCar() {
        if (crashed) {
            return;
        }

        if ((int) (Math.random() * 10) == 0) {
            changeDirection(inputType);
        }

        for (int i = 0; i < speed; i++) {
            position.updatePosition(inputType);

            checkScreenLimits();
        }
    }

    public void changeDirection(InputType lastInputType) {
        InputType direction;

        switch (lastInputType) {
            case FORWARD:
            case BACKWARDS:
                direction = ((int) (Math.random() * 2) == 0) ? InputType.RIGHT : InputType.LEFT;
                break;
            case RIGHT:
            case LEFT:
                direction = ((int) (Math.random() * 2) == 0) ? InputType.FORWARD : InputType.BACKWARDS;
                break;
            default:
                direction = null;
        }

        this.inputType = direction;
    }

    private void checkScreenLimits() {
        if (position.getCol() >= Field.getWidth() - 1) {
            inputType = InputType.BACKWARDS;
        }

        if (position.getCol() <= 0) {
            inputType = InputType.FORWARD;
        }

        if (position.getRow() >= Field.getHeight() - 1) {
            inputType = InputType.LEFT;
        }

        if (position.getRow() <= 0) {
            inputType = InputType.RIGHT;
        }
    }

    public Position getPos() {
        return position;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void crash() {
        crashed = true;
    }
}

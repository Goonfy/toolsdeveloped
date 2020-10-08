package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Supra extends Car {
    public Supra(Position position) {
        super(position);

        speed = 10;
    }

    @Override
    public String toString() {
        return CarType.SUPRA.getSymbol();
    }
}

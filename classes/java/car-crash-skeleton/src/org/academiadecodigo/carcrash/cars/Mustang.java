package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Mustang extends Car {
    public Mustang(Position position) {
        super(position);

        speed = 5;
    }

    @Override
    public String toString() {
        return CarType.MUSTANG.getSymbol();
    }
}

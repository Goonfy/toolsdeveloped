package org.academiadecodigo.carcrash.cars;

public class Fiat extends Car {
    public Fiat(int col, int row) {
        super(col, row);
    }

    @Override
    public String toString() {
        return CarType.FIAT.getSymbol();
    }
}

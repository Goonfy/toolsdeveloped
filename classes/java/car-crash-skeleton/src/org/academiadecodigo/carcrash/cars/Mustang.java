package org.academiadecodigo.carcrash.cars;

public class Mustang extends Car {
    public Mustang(int col, int row) {
        super(col, row);
    }

    @Override
    public String toString() {
        return CarType.MUSTANG.getSymbol();
    }
}

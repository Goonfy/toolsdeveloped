package org.academiadecodigo.carcrash.cars;

public class Mustang extends Car {
    public Mustang(int col, int row) {
        super(col, row);

        carBrand = CarType.MUSTANG.getSymbol();

        speed = 5;

        randomPercentage = 10;
    }

    @Override
    public String toString() {
        return carBrand;
    }
}

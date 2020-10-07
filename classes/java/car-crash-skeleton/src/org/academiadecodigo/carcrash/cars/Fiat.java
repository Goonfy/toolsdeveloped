package org.academiadecodigo.carcrash.cars;

public class Fiat extends Car {
    public Fiat(int col, int row) {
        super(col, row);

        carBrand = CarType.FIAT.getSymbol();

        speed = 1;

        randomPercentage = 20;
    }

    @Override
    public String toString() {
        return carBrand;
    }
}

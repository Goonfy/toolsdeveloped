package org.academiadecodigo.carcrash.cars;

public class Supra extends Car{
    public Supra(int col, int row) {
        super(col, row);

        carBrand = CarType.SUPRA.getSymbol();

        speed = 10;

        randomPercentage = 2;
    }

    @Override
    public String toString() {
        return carBrand;
    }
}

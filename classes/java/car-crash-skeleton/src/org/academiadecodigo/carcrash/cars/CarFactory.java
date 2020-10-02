package org.academiadecodigo.carcrash.cars;

public class CarFactory {

    public static Car getNewCar(int col, int row) {
        return (int)(Math.random() * 2) == 0 ? new Fiat(col, row) : new Mustang(col, row);
    }
}

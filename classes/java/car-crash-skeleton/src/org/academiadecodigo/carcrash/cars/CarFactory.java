package org.academiadecodigo.carcrash.cars;

public class CarFactory {
    public static Car getNewCar(int col, int row) {
        Car car = null;

        switch ((int)(Math.random() * 3)) {
            case 0:
                car = new Fiat(col, row);
                break;
            case 1:
                car = new Mustang(col, row);
                break;
            case 2:
                car = new Supra(col, row);
                break;
        }

        return car;
    }
}

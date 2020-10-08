package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {
    public static Car getNewCar(int col, int row) {
        Position position = new Position(col, row);

        CarType carType = CarType.values()[(int) (Math.random() * CarType.values().length)];

        Car car = null;

        switch (carType) {
            case FIAT:
                car = new Fiat(position);
                break;
            case MUSTANG:
                car = new Mustang(position);
                break;
            case SUPRA:
                car = new Supra(position);
                break;
        }

        return car;
    }
}

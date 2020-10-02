package org.academiadecodigo.carcrash.cars;

public enum CarType {
    FIAT("F"), // Each enum value is actually a constructor call
    MUSTANG("M");

    private String symbol;

    CarType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}

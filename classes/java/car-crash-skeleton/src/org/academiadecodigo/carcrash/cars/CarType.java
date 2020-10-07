package org.academiadecodigo.carcrash.cars;

public enum CarType {
    FIAT("F"),
    MUSTANG("M"),
    SUPRA("S");

    private String symbol;

    CarType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}

package org.academiadecodigo.sniperelite.types;

public enum BarrelType {
    PLASTIC(1),
    WOOD(5),
    METAL(15);

    private int maxDamage;

    BarrelType(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }
}

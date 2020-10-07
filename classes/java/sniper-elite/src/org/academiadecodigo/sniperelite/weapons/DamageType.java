package org.academiadecodigo.sniperelite.weapons;

public enum DamageType {
    HEAD(100),
    TORSO(50),
    LEG(10),
    FEET(5);

    private int damageMultiplier;

    DamageType(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public int getDamageMultiplier() {
        return damageMultiplier;
    }
}

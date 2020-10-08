package org.academiadecodigo.sniperelite.environment;

import org.academiadecodigo.sniperelite.objects.GameObject;
import org.academiadecodigo.sniperelite.types.BarrelType;
import org.academiadecodigo.sniperelite.types.Destroyable;

public class Barrel extends GameObject implements Destroyable {
    private final BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;

    public Barrel(BarrelType barrelType) {
        this.barrelType = barrelType;
        currentDamage = 0;
    }

    @Override
    public void hit(int damageAmount) {
        currentDamage += damageAmount;

        if (currentDamage >= barrelType.getMaxDamage()) {
            explode();
        }
    }

    private void explode() {
        destroyed = true;

        System.out.println("Exploded Barrel");
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public String getMessage() {
        return "Barrel Appeared";
    }
}

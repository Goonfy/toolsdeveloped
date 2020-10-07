package org.academiadecodigo.sniperelite.objects;

public class Barrel extends GameObject implements Destroyable {
    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;

    public Barrel() {
        int random = (int) (Math.random() * BarrelType.values().length);
        barrelType = BarrelType.values()[random];
        currentDamage = 0;
    }

    @Override
    public void hit(int damageAmount) {
        currentDamage += damageAmount;

        if (currentDamage >= barrelType.getMaxDamage()) {
            explode();
            return;
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

package org.academiadecodigo.sniperelite.weapons;

import org.academiadecodigo.sniperelite.objects.Destroyable;
import org.academiadecodigo.sniperelite.objects.Enemy;

public class SniperRifle {
    private int bulletDamage;
    private final float HIT_PROB = 0.5f;

    public SniperRifle(int bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

    public void shoot(Destroyable target) {
        if (Math.random() < HIT_PROB) {
            System.out.println("Missed");
            return;
        }

        int damageAmount = bulletDamage;

        if (target instanceof Enemy) {
            int random = (int) (Math.random() * DamageType.values().length);
            DamageType damageType = DamageType.values()[random];
            damageAmount *= damageType.getDamageMultiplier();
        }

        target.hit(damageAmount);

        System.out.println("Shooted");
    }
}

package org.academiadecodigo.sniperelite.objects;

public class ArmouredEnemy extends Enemy {
    private int armour;

    public ArmouredEnemy(int health, int armour) {
        super(health);

        this.armour = armour;
    }

    @Override
    public void hit(int damageAmount) {
        if (armour <= 0) {
            super.hit(damageAmount);
            return;
        }

        armour -= damageAmount;
    }

    @Override
    public String getMessage() {
        return "Armoured Enemy Appeared";
    }
}

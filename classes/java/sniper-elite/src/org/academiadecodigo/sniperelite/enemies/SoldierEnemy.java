package org.academiadecodigo.sniperelite.enemies;

public class SoldierEnemy extends Enemy {
    public SoldierEnemy(int health) {
        super(health);
    }

    @Override
    public String getMessage() {
        return "Soldier Enemy Appeared";
    }
}

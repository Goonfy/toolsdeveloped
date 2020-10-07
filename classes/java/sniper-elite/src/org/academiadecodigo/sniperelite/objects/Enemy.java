package org.academiadecodigo.sniperelite.objects;

public class Enemy extends GameObject implements Destroyable {
    private int health;
    private boolean dead;

    public Enemy(int health) {
        this.health = health;
    }

    public void hit(int damageAmount) {
        health -= damageAmount;

        if (health <= 0) {
            kill();
            return;
        }
    }

    public void kill() {
        dead = true;

        System.out.println("Killed Enemy");
    }

    private boolean isDead() {
        return dead;
    }

    @Override
    public boolean isDestroyed() {
        return isDead();
    }

    @Override
    public String getMessage() {
        return "Enemy Appeared";
    }
}

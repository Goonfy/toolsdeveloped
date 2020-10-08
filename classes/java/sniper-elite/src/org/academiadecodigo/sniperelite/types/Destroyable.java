package org.academiadecodigo.sniperelite.types;

public interface Destroyable {
    void hit(int damageAmount);
    boolean isDestroyed();
}

package org.academiadecodigo.sniperelite.objects;

public interface Destroyable {
    void hit(int damageAmount);
    boolean isDestroyed();
}

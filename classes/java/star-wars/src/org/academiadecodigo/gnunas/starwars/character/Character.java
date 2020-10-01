package org.academiadecodigo.gnunas.starwars.character;

public abstract class Character {

    private String name;

    public Character(String name) {
        this.name = name;
    }

    public abstract void talk(String message);
}

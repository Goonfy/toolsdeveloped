package org.academiadecodigo.bootcamp54.arabiannights;

public class Genie {
    protected int maxNumberOfWishes;
    protected int numberOfWishes;

    public Genie(int maxNumberOfWishes) {
        this.maxNumberOfWishes = maxNumberOfWishes;

        numberOfWishes = 0;
    }

    protected void grantWish() {
        numberOfWishes++;

        System.out.println("Wish granted!!");
    }
}

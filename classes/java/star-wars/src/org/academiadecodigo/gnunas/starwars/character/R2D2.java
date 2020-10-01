package org.academiadecodigo.gnunas.starwars.character;

public class R2D2 extends Character {

    public R2D2() {
        super("R2D2");
    }

    @Override
    public void talk(String message) {
        String[] newText = message.split(" ");

        for (int i = 0; i < newText.length; i++) {
            newText[i] = (int)(Math.random() * 2) == 0 ? "beep" : "bop";
        }

        System.out.println(String.join(" ", newText));
    }

    public void talk() {
        System.out.println("BEEEEEEEEEEEP BOP");
    }
}

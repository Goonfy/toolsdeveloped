package org.academiadecodigo.gnunas.starwars.character;

public class Yoda extends Character {

    public Yoda() {
        super("Yoda");
    }

    @Override
    public void talk(String message) {
        if (message.length() < 3) {
            return;
        }

        String[] oldText = message.toLowerCase().split(" ");
        String[] newText = new String[oldText.length];

        for (int i = 0; i < newText.length; i++) {
            if (i < 2) {
                newText[i] = oldText[oldText.length - 2 + i];
                continue;
            }

            newText[i] = oldText[i - 2];
        }

        newText[0] = newText[0].substring(0, 1).toUpperCase() + newText[0].substring(1);
        newText[1] = newText[1].substring(0, newText[1].length() - 1) + ",";
        newText[oldText.length - 1] += ".";

        System.out.println(String.join(" ", newText));
    }
}

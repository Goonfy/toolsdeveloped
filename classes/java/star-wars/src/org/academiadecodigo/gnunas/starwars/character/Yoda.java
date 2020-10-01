package org.academiadecodigo.gnunas.starwars.character;

public class Yoda extends Character {

    public Yoda() {
        super("Yoda");
    }

    @Override
    public void talk(String message) {
        if (message.length() < 2) {
            return;
        }

        String[] oldText = message.split(" ");
        String[] newText = new String[oldText.length - 1];

        newText[0] = oldText[oldText.length - 2] + " " + oldText[oldText.length - 1];

        for (int i = 0; i < newText[0].length(); i++) {
            if (i == 0) {
                newText[0].toString();
            }
        }

        for (int i = 1; i < newText.length; i++) {
            newText[i] = oldText[i - 1].toLowerCase();
        }

        System.out.println(String.join(" ", newText));
    }
}

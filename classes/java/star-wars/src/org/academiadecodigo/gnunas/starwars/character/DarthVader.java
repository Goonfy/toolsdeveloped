package org.academiadecodigo.gnunas.starwars.character;

public class DarthVader extends Character {

    public DarthVader() {
        super("Darth Vader");
    }

    public void talk(String message) {
        int wordCount = 0;
        String[] newText = message.split(" ");

        for (int i = 0; i < newText.length; i++) {
            wordCount++;

            if (wordCount >= 2 && i < newText.length - 1) {
                wordCount = 0;
                newText[i] += " Hwoo Haaa....";
            }
        }

        System.out.println(String.join(" ", newText));
    }
}

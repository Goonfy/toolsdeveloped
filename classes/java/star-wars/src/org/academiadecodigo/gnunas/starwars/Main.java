package org.academiadecodigo.gnunas.starwars;

import org.academiadecodigo.gnunas.starwars.character.Character;
import org.academiadecodigo.gnunas.starwars.character.DarthVader;
import org.academiadecodigo.gnunas.starwars.character.R2D2;
import org.academiadecodigo.gnunas.starwars.character.Yoda;

public class Main {

    public static void main(String[] args) {
        Character[] characters = new Character[] {
            new Yoda(),
            new R2D2(),
            new DarthVader()
        };

        for (Character character : characters) {
            character.talk("May the force be with you!");
        }
    }
}

package org.academiadecodigo.bootcamp54.arabiannights;

public class Main {
    public static void main(String[] args) {
        MagicLamp magicLamp = new MagicLamp(1);
        Genie genie1 = magicLamp.rubTheLamp();
        genie1.grantWish();
        genie1.grantWish();
        genie1.grantWish();
        Genie genie2 = magicLamp.rubTheLamp();
        genie2.grantWish();

        magicLamp.rechargeLamp(genie2);

        MagicLamp magicLamp1 = new MagicLamp(10);
        MagicLamp magicLamp2 = new MagicLamp(9);

        if (magicLamp1.compareToLamp(magicLamp2)) {
            System.out.println("Lamps are equal");
            return;
        }

            System.out.println("Diferent lamps");
    }
}


package org.academiadecodigo.bootcamp54.arabiannights;

public class MagicLamp {
    private final int maxGeniesNumber;
    private int geniesNumber;
    private int timesRecharged;

    public MagicLamp(int maxGeniesNumber) {
        this.maxGeniesNumber = maxGeniesNumber;
        geniesNumber = 0;

        timesRecharged = 0;
    }

    public Genie rubTheLamp() {
        if (geniesNumber >= maxGeniesNumber) {
            return new RecyclableDemon(2);
        }

        Genie genie = geniesNumber % 2 == 0 ? new FriendlyGenie(2) : new GrumpyGenie(2);

        geniesNumber++;

        return genie;
    }

    public void rechargeLamp(Genie genie) {
        if (genie instanceof RecyclableDemon) {
            RecyclableDemon recyclableDemon = (RecyclableDemon)genie;

            if (!recyclableDemon.isRecycled()) {
                timesRecharged++;
                geniesNumber = 0;

                recyclableDemon.recycle();

                System.out.println("Recharged Lamp");

                return;
            }

            System.out.println("Already recharged");

            return;
        }

        System.out.println("Not a recyclable demon");
    }

    public boolean compareToLamp(MagicLamp magicLamp) {
        return geniesNumber == magicLamp.geniesNumber
                && maxGeniesNumber == magicLamp.maxGeniesNumber
                && timesRecharged == magicLamp.timesRecharged;
    }
}

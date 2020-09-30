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
        if(geniesNumber < maxGeniesNumber) {
            return;
        }

        if (genie instanceof RecyclableDemon) {
            RecyclableDemon recyclableDemon = (RecyclableDemon) genie;

            if (recyclableDemon.isRecycled()) {
                // It can only be recycled once
                timesRecharged++;
                geniesNumber = maxGeniesNumber;

                recyclableDemon.recycle();
            }
        }
    }

    public boolean compareToLamp(MagicLamp magicLamp) {
        return geniesNumber == magicLamp.geniesNumber
                && maxGeniesNumber == magicLamp.maxGeniesNumber
                && timesRecharged == magicLamp.timesRecharged;
    }
}

package org.academiadecodigo.bootcamp54.arabiannights;

public class GrumpyGenie extends Genie {
    public GrumpyGenie(int maxNumberOfWishes) {
        super(maxNumberOfWishes);

        System.out.println("Spawned Grumpy Genie");
    }

    @Override
    protected void grantWish() {
        if (numberOfWishes < 1) {
            super.grantWish();

            return;
        }

        System.out.println("No more wishes for you!!");
    }
}

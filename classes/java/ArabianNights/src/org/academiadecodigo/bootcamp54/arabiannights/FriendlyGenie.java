package org.academiadecodigo.bootcamp54.arabiannights;

public class FriendlyGenie extends Genie {
    public FriendlyGenie(int maxNumberOfWishes) {
        super(maxNumberOfWishes);

        System.out.println("Spawned Friendly Genie");
    }

    @Override
    protected void grantWish() {
        if (numberOfWishes < maxNumberOfWishes) {
            super.grantWish();

            return;
        }

        System.out.println("No more wishes for you!!");
    }
}

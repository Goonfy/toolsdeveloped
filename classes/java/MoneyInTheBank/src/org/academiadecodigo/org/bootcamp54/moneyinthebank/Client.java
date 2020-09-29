package org.academiadecodigo.org.bootcamp54.moneyinthebank;

public class Client {
    private Wallet wallet;

    private String name;

    public Client(String name, int balance) {
        this.name = name;

        wallet = new Wallet(balance);
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }
}

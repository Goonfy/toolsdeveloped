package org.academiadecodigo.org.bootcamp54.moneyinthebank;

public class Wallet {
    private int walletBalance;

    public Wallet(int walletBalance) {
        this.walletBalance = walletBalance;

        System.out.println("Starting wallet balance: " + getWalletBalance());
    }

    public void addMoney(int value) {
        walletBalance += value;
    }

    public void removeMoney(int value) {
        walletBalance -= value;
    }

    public int getWalletBalance() {
        return walletBalance;
    }
}

package org.academiadecodigo.org.bootcamp54.moneyinthebank;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Noélio", 2000);

        Bank bank = new Bank(client, 1000);
        bank.addBankBalance(10);
        bank.removeBankBalance(500);

        System.out.println("Wallet balance: " + client.getWallet().getWalletBalance());
        System.out.println("Bank account balance: " + bank.getBankBalance());
    }
}

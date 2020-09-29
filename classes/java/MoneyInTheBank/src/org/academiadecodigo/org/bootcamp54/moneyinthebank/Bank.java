package org.academiadecodigo.org.bootcamp54.moneyinthebank;

public class Bank {
    private Client client;

    private int bankBalance;

    public Bank(Client client, int bankBalance) {
        this.bankBalance = bankBalance;
        this.client = client;

        System.out.println("Starting Balance: " + bankBalance);
    }

    public void addBankBalance(int value) {
        if (client.getWallet().getWalletBalance() < value) {
            System.out.println("No balance available on wallet");
            return;
        }

        if (checkMoneyBill(value)) {
            bankBalance += value;
            client.getWallet().removeMoney(value);
            System.out.println("Deposit: " + value);
        }
    }

    public void removeBankBalance(int value) {
        if (bankBalance < value) {
            System.out.println("No balance available on bank account");
            return;
        }

        if(checkMoneyBill(value)) {
            bankBalance -= value;
            client.getWallet().addMoney(value);
            System.out.println("Withraw: " + value);
        }
    }

    public boolean checkMoneyBill(int moneyBill) {
        switch (moneyBill) {
            case 5:
            case 10:
            case 20:
            case 50:
            case 100:
            case 200:
            case 500:
                break;
            default:
                System.out.println("Só é permitido depositar notas de 5, 10, 20, 50, 100, 200 e 500");
                return false;
        }

        return true;
    }

    public int getBankBalance() {
        return bankBalance;
    }
}

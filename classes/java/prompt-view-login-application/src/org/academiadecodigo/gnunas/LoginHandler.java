package org.academiadecodigo.gnunas;

import java.util.List;
import java.util.Map;

public class LoginHandler {

    private final InputHandler inputHandler;

    private final List<Account> accounts;

    public LoginHandler(List<Account> accounts, InputHandler inputHandler) {
        this.inputHandler = inputHandler;

        this.accounts = accounts;
    }

    public void handle() {
        Account getInputAccount = inputHandler.getInput();

        for (Account account : accounts) {
            if (account.getUsername().equals(getInputAccount.getUsername()) ||
                    account.getPassword().equals(getInputAccount.getPassword())) {
                System.out.println("Your login was successful, Welcome " + account.getUsername());

                return;
            }
        }

        System.out.println("Wrong account information, try again");
    }
}

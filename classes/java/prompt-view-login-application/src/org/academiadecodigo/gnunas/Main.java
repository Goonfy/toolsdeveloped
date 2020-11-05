package org.academiadecodigo.gnunas;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Account> accounts = new LinkedList<>();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("resources/database")));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] account = line.split(" ");
                accounts.add(new Account(account[0], account[1]));
            }

            LoginHandler loginHandler = new LoginHandler(accounts,
                    new InputHandler());
            loginHandler.handle();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

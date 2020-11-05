package org.academiadecodigo.gnunas;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.LinkedHashMap;
import java.util.Map;

public class InputHandler {

    private final Prompt prompt;
    private final StringInputScanner usernameQuestion;
    private final StringInputScanner passwordQuestion;

    public InputHandler() {
        prompt = new Prompt(System.in, System.out);

        usernameQuestion = new StringInputScanner();
        usernameQuestion.setMessage("What is your username?\n");

        passwordQuestion = new PasswordInputScanner();
        passwordQuestion.setMessage("What is your password?\n");
    }

    public Account getInput() {
        String username = prompt.getUserInput(usernameQuestion);
        String password = prompt.getUserInput(passwordQuestion);

        return new Account(username, password);
    }
}

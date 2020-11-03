package org.academiadecodigo.gnunas.client;

import org.academiadecodigo.gnunas.server.ClientHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private final Socket clientSocket;
    private InputHandler inputHandler;

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void start() {
        System.out.println("Connected to Server");

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        while (true) {
            fixedPool.submit(inputHandler = new InputHandler());

            fixedPool.submit(new ChatHandler(clientSocket, this));
        }
    }

    protected byte[] getInput() {
        return inputHandler.getInput();
    }
}

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

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void start() {
        System.out.println("Connected to Server");

        ChatHandler chatHandler;

        ExecutorService fixedPool = Executors.newFixedThreadPool(1);
        fixedPool.submit(chatHandler = new ChatHandler(clientSocket, this));

        new InputHandler(chatHandler).init();
    }
}

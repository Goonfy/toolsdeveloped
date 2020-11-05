package org.academiadecodigo.gnunas.client;

import org.academiadecodigo.gnunas.server.ClientHandler;

import java.io.*;
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

        ExecutorService fixedPool = Executors.newSingleThreadExecutor();
        fixedPool.submit(new ChatHandler(this));

        new InputHandler(this).init();
    }

    private BufferedInputStream receivePacketFromServer() throws IOException {
        return new BufferedInputStream(clientSocket.getInputStream());
    }

    protected String decodePacketFromServer() throws IOException {
        return new BufferedReader(new InputStreamReader(receivePacketFromServer())).readLine();
    }

    protected void sendMessagePacketToServer(String input) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(clientSocket.getOutputStream());
        bufferedOutputStream.write((input + "\n").getBytes());
        bufferedOutputStream.flush();
    }
}

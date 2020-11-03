package org.academiadecodigo.gnunas.server;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ServerSocket serverSocket;

    private final List<Socket> connectedClients = new LinkedList<>();

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void start() throws IOException {
        System.out.println("Server Started");

        ExecutorService fixedPool = Executors.newFixedThreadPool(10);

        while (true) {
            fixedPool.submit(new ClientHandler(serverSocket.accept(), this));
        }
    }

    protected void connect(Socket connectedClient) {
        System.out.println("Client Connected");

        connectedClients.add(connectedClient);
    }

    protected void disconnect(Socket connectedClient) {
        System.out.println("Client Disconnected");

        connectedClients.remove(connectedClient);
    }

    protected void halt() {

    }

    protected List<Socket> getConnectedClients() {
        return connectedClients;
    }
}

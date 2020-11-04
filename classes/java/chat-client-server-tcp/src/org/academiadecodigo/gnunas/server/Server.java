package org.academiadecodigo.gnunas.server;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ServerSocket serverSocket;

    private final List<User> connectedClients;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;

        connectedClients = new LinkedList<>();
    }

    public void start() throws IOException {
        System.out.println("Server Started");

        ExecutorService fixedPool = Executors.newFixedThreadPool(10);

        while (true) {
            fixedPool.submit(new ClientHandler(serverSocket.accept(), this));
        }
    }

    protected BufferedReader receivePacket(Socket clientSocket) throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    protected void sendPacketToAll(String message) throws IOException {
        for (User user : getConnectedClients()) {
            PrintWriter fileWriter = new PrintWriter(user.getClientSocket().getOutputStream(), true);
            fileWriter.println(message);
        }
    }

    protected void sendPacketTo(Socket clientSocket, String message) throws IOException {
        PrintWriter fileWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        fileWriter.println(message);
    }

    protected void connect(Socket connectedClient, String username) throws IOException {
        String message = "Client " + username + " Connected";
        System.out.println(message);
        sendPacketToAll(message);

        connectedClients.add(new User(connectedClient, username));

        sendPacketTo(connectedClient, "Welcome to this amazing chat ma friend...");
    }

    protected void disconnect(Socket connectedClient) throws IOException {
        for (User user : connectedClients) {
            if (user.getClientSocket() != connectedClient) {
                continue;
            }

            String message = "Client " + user.getUsername() + " Disconnected";
            System.out.println(message);

            connectedClients.remove(user);

            sendPacketToAll(message);

            break;
        }
    }

    protected boolean logout(Socket clientSocket, String message) throws IOException {
        if (!message.equals("/logout")) {
            return false;
        }

        disconnect(clientSocket);
        clientSocket.close();

        return true;
    }

    protected boolean usernameExists(String username) {
        for (User user : connectedClients) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    protected List<User> getConnectedClients() {
        return connectedClients;
    }
}

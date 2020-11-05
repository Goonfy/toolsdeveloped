package org.academiadecodigo.gnunas.server;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ServerSocket serverSocket;

    private final LinkedList<User> connectedClients;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;

        connectedClients = new LinkedList<>();
    }

    public void start() throws IOException {
        System.out.println("Server Started");

        CommandListener commandListener = new CommandListener(this);

        ExecutorService fixedPool = Executors.newFixedThreadPool(10);
        while (true) {
            fixedPool.submit(new ClientHandler(serverSocket.accept(), this, commandListener));
        }
    }

    protected BufferedInputStream receivePacketFrom(Socket clientSocket) throws IOException {
        return new BufferedInputStream(clientSocket.getInputStream());
    }

    protected String decodePacketFrom(Socket clientSocket) throws IOException {
        return new BufferedReader(new InputStreamReader(receivePacketFrom(clientSocket))).readLine();
    }

    protected void sendMessagePacketToAll(String message) throws IOException {
        for (User user : getConnectedClients()) {
            sendMessagePacketTo(user.getClientSocket(), message);
        }
    }

    protected void sendMessagePacketTo(Socket clientSocket, String message) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(clientSocket.getOutputStream());
        bufferedOutputStream.write((message + "\n").getBytes());
        bufferedOutputStream.flush();
    }

    protected void connect(Socket clientSocket, String username) throws IOException {
        String message = "Client " + username + " Connected";
        System.out.println(message);
        sendMessagePacketToAll(message);

        connectedClients.add(new User(clientSocket, username));

        String welcomeMessage = "Welcome to this amazing chat ma friend... " +
                "Online users: " + connectedClients.toString();
        sendMessagePacketTo(clientSocket, welcomeMessage);
    }

    protected void disconnect(Socket clientSocket) throws IOException {
        if (clientSocket == null) {
            return;
        }

        for (User user : connectedClients) {
            if (user.getClientSocket() != clientSocket) {
                continue;
            }

            String message = "Client " + user.getUsername() + " Disconnected";
            System.out.println(message);

            connectedClients.remove(user);

            sendMessagePacketToAll(message);

            break;
        }

        clientSocket.close();
    }

    protected User getUser(String username) {
        for (User user : connectedClients) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    protected List<User> getConnectedClients() {
        return connectedClients;
    }
}

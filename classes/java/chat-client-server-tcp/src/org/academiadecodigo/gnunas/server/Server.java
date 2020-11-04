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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(receivePacketFrom(clientSocket)));

        char[] buffer = new char[1024];
        int i = bufferedReader.read(buffer);

        return new String(buffer);

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(receivePacketFrom(clientSocket)));
        return bufferedReader.readLine();*/
    }

    protected void sendPacketToAll(byte[] message) throws IOException {
        for (User user : getConnectedClients()) {
            sendPacketTo(user.getClientSocket(), message);
        }
    }

    protected void sendPacketTo(Socket clientSocket, byte[] message) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(clientSocket.getOutputStream());
        bufferedOutputStream.write(message);
        bufferedOutputStream.write("\n".getBytes());
        bufferedOutputStream.flush();

        //clientSocket.getOutputStream().write(message);
        //clientSocket.getOutputStream().write("\n".getBytes());
    }

    protected void connect(Socket clientSocket, String username) throws IOException {
        String message = "Client " + username + " Connected";
        System.out.println(message);
        sendPacketToAll(message.getBytes());

        connectedClients.add(new User(clientSocket, username));

        String welcomeMessage = "Welcome to this amazing chat ma friend... " +
                "Online users: " + connectedClients.toString();
        sendPacketTo(clientSocket, welcomeMessage.getBytes());
    }

    protected void disconnect(Socket clientSocket) throws IOException {
        for (User user : connectedClients) {
            if (user.getClientSocket() != clientSocket) {
                continue;
            }

            String message = "Client " + user.getUsername() + " Disconnected";
            System.out.println(message);

            connectedClients.remove(user);

            sendPacketToAll(message.getBytes());

            break;
        }

        clientSocket.close();
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

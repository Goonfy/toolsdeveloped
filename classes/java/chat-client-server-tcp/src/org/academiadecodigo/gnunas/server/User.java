package org.academiadecodigo.gnunas.server;

import java.net.Socket;

public class User {
    private String username;

    private final Socket clientSocket;

    public User(Socket clientSocket, String username) {
        this.clientSocket = clientSocket;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected String getUsername() {
        return username;
    }

    protected Socket getClientSocket() {
        return clientSocket;
    }

    @Override
    public String toString() {
        return username;
    }
}

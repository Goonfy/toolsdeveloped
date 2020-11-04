package org.academiadecodigo.gnunas;

import org.academiadecodigo.gnunas.server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class ServerLauncher {
    private static final int PORT_NUMBER = 55000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            new Server(serverSocket).start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
           close(serverSocket);
        }
    }

    private static void close(ServerSocket serverSocket) {
        try {
            Objects.requireNonNull(serverSocket).close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

package org.academiadecodigo.gnunas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class WebServerStarter {
    private static final int PORT_NUMBER = 8888;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT_NUMBER);

            while (true) {
                Thread thread = new Thread(new Server(serverSocket.accept()));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(serverSocket);
        }
    }

    private static void close(ServerSocket serverSocket) {
        try {
            Objects.requireNonNull(serverSocket).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

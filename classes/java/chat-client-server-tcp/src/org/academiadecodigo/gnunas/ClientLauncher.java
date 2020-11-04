package org.academiadecodigo.gnunas;

import org.academiadecodigo.gnunas.client.Client;

import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class ClientLauncher {
    private static final String HOST_NAME = "localhost";
    private static final int PORT_NUMBER = 55000;

    public static void main(String[] args) {
        Socket clientSocket = null;

        try {
            clientSocket = new Socket(HOST_NAME, PORT_NUMBER);
            new Client(clientSocket).start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (clientSocket != null) {
                close(clientSocket);
            }
        }
    }

    private static void close(Socket clientSocket) {
        try {
            clientSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

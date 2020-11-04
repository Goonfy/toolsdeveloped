package org.academiadecodigo.gnunas.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatHandler implements Runnable {
    private final Socket clientSocket;
    private final Client client;

    public ChatHandler(Socket clientSocket, Client client) {
        this.clientSocket = clientSocket;
        this.client = client;
    }

    private BufferedReader receivePacket() throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    protected void sendPacket(byte[] input) throws IOException {
        PrintWriter fileWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        fileWriter.println(new String(input));
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedReader receivedData = receivePacket();
                String receivedMessage = receivedData.readLine();

                if (receivedMessage == null) {
                    System.out.println("Connection terminated, goodbye...");
                    System.exit(0);
                }

                System.out.println(receivedMessage);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

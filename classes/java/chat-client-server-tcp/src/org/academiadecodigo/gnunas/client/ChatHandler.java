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

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("test");

                BufferedReader receivedData = receivePacket();
                String receivedMessage = receivedData.readLine();
                System.out.println(receivedMessage);

                if (client.getInput().length > 0) {
                    sendPacket(client.getInput());
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot send or receive data " + e.getMessage());
        }
    }

    private BufferedReader receivePacket() throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private void sendPacket(byte[] input) throws IOException {
        PrintWriter fileWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        fileWriter.println(new String(input));
    }
}

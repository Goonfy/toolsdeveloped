package org.academiadecodigo.gnunas.client;

import java.io.*;
import java.net.Socket;

public class ChatHandler implements Runnable {
    private final Socket clientSocket;

    public ChatHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    private InputStream receivePacketFromServer() throws IOException {
        return clientSocket.getInputStream();
    }

    private String decodePacketFromServer() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(receivePacketFromServer()));
        return bufferedReader.readLine();
    }

    protected void sendPacketToServer(byte[] input) throws IOException {
        clientSocket.getOutputStream().write(input);
        clientSocket.getOutputStream().write("\n".getBytes());
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = decodePacketFromServer();

                if (message == null) {
                    System.out.println("Connection terminated, goodbye...");
                    System.exit(0);
                }

                System.out.println(message);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

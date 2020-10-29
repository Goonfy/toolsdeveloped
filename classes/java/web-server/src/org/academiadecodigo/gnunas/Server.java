package org.academiadecodigo.gnunas;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {
    private final int PORT_NUMBER = 8888;

    private ServerSocket serverSocket;
    private Socket clientSocket;

    public void init() {
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            server();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            Objects.requireNonNull(serverSocket).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void server() throws IOException {
        clientSocket = serverSocket.accept();

        String[] line = receivePacket().readLine().split(" ");
        String httpVerb = line[0];
        String path = line[1];

        if (httpVerb.equals("GET")) {
            if (path.equals("/")) {
                path = "/index.html";
            }

            File file = new File("www" + path);

            byte[] header = ("HTTP/1.0 200 Document Follows\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length: " + file.length() + "\r\n" +
                    "\r\n").getBytes();

            sendPacket(header, file);
        }

        server();
    }

    private byte[] fileToBytes(File file) throws IOException {
        byte[] bufferReader = new byte[1024];
        FileInputStream fileReader = new FileInputStream(file);
        fileReader.read(bufferReader);
        return bufferReader;
    }

    private BufferedReader receivePacket() throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private void sendPacket(byte[] header, File file) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        dataOutputStream.write(header);
        dataOutputStream.write(fileToBytes(file));
        dataOutputStream.flush();
    }
}

package org.academiadecodigo.gnunas;

import org.academiadecodigo.gnunas.handler.HeaderType;

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

            byte[] header = null;
            if (!file.exists() || !path.contains(".")) {
                file = new File("www/404.html");
                header = HeaderType.NOTFOUND.setHeader(file);
            }
            else if (path.contains(".png") || path.contains(".jpg") || path.contains(".gif")) {
                header = HeaderType.IMAGE.setHeader(file);
            }
            else if (path.contains(".html")) {
                header = HeaderType.HTML.setHeader(file);
            }

            if (header != null) {
                sendPacket(header, file);
            }

            server();
        }
    }

    private BufferedReader receivePacket() throws IOException {
        return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private void sendPacket(byte[] header, File file) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        FileInputStream fileInputStream = new FileInputStream(file);

        dataOutputStream.write(header);

        byte[] buffer = new byte[1024];
        while (fileInputStream.available() != 0) {
            int readBytes = fileInputStream.read(buffer);
            dataOutputStream.write(buffer, 0, readBytes);
        }
    }
}

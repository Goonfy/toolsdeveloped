package org.academiadecodigo.gnunas.server;

import java.io.IOException;
import java.net.Socket;

public class CommandListener {
    private final Server server;

    public CommandListener(Server server) {
        this.server = server;
    }

    protected boolean logout(Socket clientSocket, String message) throws IOException {
        if (!message.equals("/logout")) {
            return false;
        }

        server.disconnect(clientSocket);

        return true;
    }
}

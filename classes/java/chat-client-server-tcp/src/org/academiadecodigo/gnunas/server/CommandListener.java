package org.academiadecodigo.gnunas.server;

import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class CommandListener {
    private final Server server;

    public CommandListener(Server server) {
        this.server = server;
    }

    protected boolean check(String username, String message) throws IOException {
        if (message.contains("/kick")) {
            return kick(message);
        }

        return false;
    }

    protected boolean kick(String message) throws IOException {
        String[] m = message.split(" ");
        if (m.length < 2) {
            return false;
        }

        String toUser = m[1];
        User user = server.getUser(toUser);
        if (user == null) {
            return false;
        }

        Socket userSocket = user.getClientSocket();

        server.sendMessagePacketToAll(toUser + " has been kicked!!");
        server.disconnect(userSocket);

        return true;
    }

    protected boolean logout(String username) throws IOException {
        server.disconnect(server.getUser(username).getClientSocket());
        return true;
    }

    protected boolean users(String username) throws IOException {
        if (server.getUser(username) == null) {
            return false;
        }

        server.sendMessagePacketTo(server.getUser(username).getClientSocket(), "Online users: " + server.getConnectedClients().toString());

        return true;
    }

    protected boolean name(String message) throws IOException {
        String[] m = message.split(" ");
        if (m.length < 2) {
            return false;
        }

        String toUser = m[1];
        User user = server.getUser(toUser);
        if (user == null) {
            return false;
        }

        server.sendMessagePacketToAll(user + " changed username to " + toUser);
        user.setUsername(toUser);

        return true;
    }

    protected boolean pm(String username, String message) throws IOException {
        String[] m = message.split(" ");
        if (m.length < 3) {
            return false;
        }

        String toUser = m[1];
        Socket userSocket = server.getUser(toUser).getClientSocket();
        if (userSocket == null) {
            return false;
        }

        server.sendMessagePacketTo(userSocket, "[PM] " + m[2]);

        return true;
    }
}

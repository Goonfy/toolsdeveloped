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
            kick(message);
            return true;
        }

        return false;
    }

    protected void kick(String message) throws IOException {
        String[] m = message.split(" ");
        if (m.length < 2) {
            return;
        }

        String toUser = m[1];
        Socket userSocket = server.getUser(toUser).getClientSocket();
        if (userSocket == null) {
            return;
        }

        server.sendMessagePacketToAll(toUser + " has been kicked!!");
        server.disconnect(userSocket);
    }

    protected void logout(String username) throws IOException {
        server.disconnect(server.getUser(username).getClientSocket());
    }

    protected void users(String username) throws IOException {
        if (server.getUser(username) == null) {
            return;
        }

        server.sendMessagePacketTo(server.getUser(username).getClientSocket(), "Online users: " + server.getConnectedClients().toString());
    }

    protected void name(String message) throws IOException {
        String[] m = message.split(" ");
        if (m.length < 2) {
            return;
        }

        String toUser = m[1];
        User user = server.getUser(toUser);
        if (user == null) {
            return;
        }

        server.sendMessagePacketToAll(user + " changed username to " + toUser);
        user.setUsername(toUser);
    }

    protected void pm(String username, String message) throws IOException {
        String[] m = message.split(" ");
        if (m.length < 2) {
            return;
        }

        String toUser = m[1];
        Socket userSocket = server.getUser(toUser).getClientSocket();
        if (userSocket == null) {
            return;
        }

        server.sendMessagePacketTo(userSocket, "[PM] " + message);

    }
}

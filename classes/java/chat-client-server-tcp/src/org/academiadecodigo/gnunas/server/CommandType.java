package org.academiadecodigo.gnunas.server;

public enum CommandType {
    KICK("/kick"),
    LOGOUT("/logout"),
    USERS("/users"),
    NAME("/name"),
    PM("/pm");

    String command;

    CommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}

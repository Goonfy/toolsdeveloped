package org.academiadecodigo.bootcamp.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionManager {

    private Connection connection = null;

    private final static String dbUrl = "jdbc:mysql://localhost:3306/ac";
    private final static String user = "root";
    private final static String pass = "";

    public Connection getConnection() {

        try {
            if (!Optional.ofNullable(connection).isPresent()) {
                connection = DriverManager.getConnection(dbUrl, user, pass);
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database : " + ex.getMessage());
        }

        return connection;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }
}

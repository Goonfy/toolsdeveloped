package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.utils.Security;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JdbcUserService implements UserService {

    private final Connection dbConnection;

    public JdbcUserService(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean authenticate(String username, String password) {
        try {
            String query = "SELECT username, password FROM user WHERE username = ? AND password = ?";

            PreparedStatement statement = dbConnection.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, Security.getHash(password));

            return statement.executeQuery().next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public void add(User user) {
        try {
            String queryInsert = "INSERT INTO user (username, password, email, firstname, lastname, phone) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = dbConnection.prepareStatement(queryInsert);

            if (findByName(user.getUsername()) != null) {
                return;
            }

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getPhone());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User findByName(String username) {
        User user = null;

        try {
            String query = "SELECT * FROM user WHERE username = ?";

            PreparedStatement statement = dbConnection.prepareStatement(query);

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(resultSet.getString("username"),
                        resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getString("firstname"), resultSet.getString("lastname"),
                        resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    @Override
    public List<User> findAll() {

        List<User> list = new LinkedList<>();

        try {
            String query = "SELECT * FROM user";

            PreparedStatement statement = dbConnection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                list.add(new User(resultSet.getString("username"), resultSet.getString("email"),
                        resultSet.getString("password"), resultSet.getString("firstname"),
                        resultSet.getString("lastname"), resultSet.getString("phone")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public int count() {
        int result = 0;

        try {
            String query = "SELECT COUNT(*) FROM user";

            PreparedStatement statement = dbConnection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

            return result;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}

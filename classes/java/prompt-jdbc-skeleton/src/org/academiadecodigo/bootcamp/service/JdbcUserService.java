package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.utils.Security;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class JdbcUserService implements UserService {

    private final Connection dbConnection;

    public JdbcUserService(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean authenticate(String username, String password) {
        PreparedStatement statement = null;

        try {
            String query = "SELECT username, password FROM user WHERE username = ? AND password = ?";

            statement = dbConnection.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, Security.getHash(password));

            return statement.executeQuery().next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Optional.ofNullable(statement).ifPresent(this::close);
        }

        return false;
    }

    @Override
    public void add(User user) {
        PreparedStatement statement = null;

        try {
            String queryInsert = "INSERT INTO user (username, password, email, firstname, lastname, phone) VALUES (?, ?, ?, ?, ?, ?)";

            statement = dbConnection.prepareStatement(queryInsert);

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
        } finally {
            Optional.ofNullable(statement).ifPresent(this::close);
        }
    }

    @Override
    public User findByName(String username) {
        PreparedStatement statement = null;

        User user = null;

        try {
            String query = "SELECT * FROM user WHERE username = ?";

            statement = dbConnection.prepareStatement(query);

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
        } finally {
            Optional.ofNullable(statement).ifPresent(this::close);
        }

        return user;
    }

    @Override
    public List<User> findAll() {
        PreparedStatement statement = null;

        List<User> list = new LinkedList<>();

        try {
            String query = "SELECT * FROM user";

            statement = dbConnection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                list.add(new User(resultSet.getString("username"), resultSet.getString("email"),
                        resultSet.getString("password"), resultSet.getString("firstname"),
                        resultSet.getString("lastname"), resultSet.getString("phone")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Optional.ofNullable(statement).ifPresent(this::close);
        }

        return list;
    }

    @Override
    public int count() {
        PreparedStatement statement = null;

        int result = 0;

        try {
            String query = "SELECT COUNT(*) FROM user";

            statement = dbConnection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

            return result;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Optional.ofNullable(statement).ifPresent(this::close);
        }

        return result;
    }

    private void close(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

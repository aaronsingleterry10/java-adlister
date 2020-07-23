package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Long insert(User user) {
        String query = String.format("INSERT INTO users(username, email, password) VALUES ('%s', '%s', '%s')",
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
        long lastGeneratedId = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            lastGeneratedId = rs.getLong(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lastGeneratedId;
    }

    public static void main(String[] args) {
        User testUser = new User("test_user", "test_email", "test_password");
        Users userDao = new MySQLUsersDao(new Config());
        System.out.println(userDao.insert(testUser));
    }
}


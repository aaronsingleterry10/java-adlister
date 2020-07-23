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
        Config config = new Config();
        User user = null;
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            String query = String.format("SELECT * FROM users WHERE username LIKE '%s'", username);
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            rs.next();
            user = new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
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

    public static void main(String[] args) throws SQLException {
//        User testUser = new User("test_user", "test_email", "test_password");
//        Users userDao = new MySQLUsersDao(new Config());
//        System.out.println(userDao.insert(testUser));
        System.out.println(DaoFactory.getUsersDao().findByUsername("myUsername"));
//        Config config = new Config();
//        Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
//        DriverManager.registerDriver(new Driver());
//        String query = "SELECT * FROM users WHERE username LIKE 'myUsername'";
//        PreparedStatement statement = connection.prepareStatement(query);
//        ResultSet rs = statement.executeQuery();
//        rs.next();
//        System.out.println(rs.getLong(1));
    }
}


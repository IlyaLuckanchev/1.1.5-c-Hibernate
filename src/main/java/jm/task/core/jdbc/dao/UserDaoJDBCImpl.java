package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            String sqlCommand = "CREATE TABLE IF NOT EXISTS Users (IdUsers INT PRIMARY KEY AUTO_INCREMENT," +
                    " name VARCHAR(100), lastName VARCHAR(100), age INT)";
            statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            String sqlCommand = "DROP TABLE IF EXISTS Users";
            statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String insertSQL = "INSERT INTO Users (name, lastName, age) VALUES (?, ?, ?)";
        try (Connection connection = Util.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String removeSQL = "DELETE FROM Users WHERE IdUsers = ?";
        try (Connection connection = Util.getConnection();
             PreparedStatement statement = connection.prepareStatement(removeSQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();
        String getAllUsers = "SELECT * FROM Users";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(getAllUsers)) {
            while (result.next()) {
                User user = new User();
                user.setId(result.getLong(1));
                user.setName(result.getString(2));
                user.setLastName(result.getString(3));
                user.setAge(result.getByte(4));
                allUsers.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUsers;
    }

    public void cleanUsersTable() {
        String clear = "TRUNCATE TABLE Users";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(clear);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
private final Connection connection = Util.getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String sqlCommand = "CREATE TABLE Users (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), lastName VARCHAR(100), age INT)";
            statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String sqlCommand = "DROP TABLE Users";
            statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}

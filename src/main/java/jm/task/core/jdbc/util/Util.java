package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return connection;
    }
}


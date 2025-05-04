package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return connection;
    }
}


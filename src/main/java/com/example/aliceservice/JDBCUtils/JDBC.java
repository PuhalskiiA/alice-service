package com.example.aliceservice.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public static Connection getNewConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/datePlanner";
        Connection connection = DriverManager.getConnection(url, "postgres", "postgres");

        if (connection.isValid(1)) {
            System.out.println("Connection is successful");
        }

        return connection;
    }
}

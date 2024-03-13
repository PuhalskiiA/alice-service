package com.example.aliceservice.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

import static com.example.aliceservice.JDBCUtils.JDBC.getNewConnection;

public class JDBCConnection {
    public static void main(String[] args) {
        try {
            Connection connection  = getNewConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
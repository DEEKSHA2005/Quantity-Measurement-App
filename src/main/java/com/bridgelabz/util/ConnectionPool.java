package com.bridgelabz.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {

    private static final String URL = "jdbc:mysql://localhost:3306/quantity_db";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
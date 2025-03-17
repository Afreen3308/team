package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Admin";

    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

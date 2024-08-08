package com.example.test_module3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static final String PROPERTIES_FILE = "db.properties";
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(DatabaseConnection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
            Class.forName(properties.getProperty("db.driver"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Database Connection Initialization Failed");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.username"),
                properties.getProperty("db.password")
        );
    }
}


package org.example.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionDBSingleton {
    private static ConnectionDBSingleton instance;
    private static final Connection connection;

    static {
        String url = "url";
        String user = "user";
        String password = "password";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ConnectionDBSingleton() {}

    public static ConnectionDBSingleton getInstance() {
        if (instance == null) {
            instance = new ConnectionDBSingleton();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

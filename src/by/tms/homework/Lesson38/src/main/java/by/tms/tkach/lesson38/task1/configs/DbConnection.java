package by.tms.tkach.lesson38.task1.configs;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class DbConnection {

    private String url;
    private String user;
    private String password;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}

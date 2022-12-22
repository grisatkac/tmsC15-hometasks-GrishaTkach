package by.tms.tkach.lesson38.task3.configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class DbConnection {

    @Value("${db.todo.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

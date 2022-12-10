package by.tms.helpdesk.lesson34.repositories;

import by.tms.helpdesk.lesson34.entities.AbstractEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Repository<T extends AbstractEntity> {

    static Connection getConnection() throws SQLException {
        String url =  RepositoryProperties.URL.getProperty();
        String user =  RepositoryProperties.USER.getProperty();
        String password =  RepositoryProperties.PASSWORD.getProperty();

        return DriverManager.getConnection(url, user, password);
    }
}

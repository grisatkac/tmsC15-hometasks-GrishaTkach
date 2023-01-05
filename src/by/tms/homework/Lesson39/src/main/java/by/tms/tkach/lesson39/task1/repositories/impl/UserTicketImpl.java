package by.tms.tkach.lesson39.task1.repositories.impl;

import by.tms.tkach.lesson39.task1.configs.DbConnection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
@AllArgsConstructor
public class UserTicketImpl {

    private DbConnection dbConnection;

    public boolean add(Long entityId, String query) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, entityId);
        int result = preparedStatement.executeUpdate();

        return result != 0;
    }

    public boolean delete(Long entityId, String query) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, entityId);
        int result = preparedStatement.executeUpdate();

        return result != 0;
    }

}

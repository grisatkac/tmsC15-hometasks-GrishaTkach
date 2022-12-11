package by.tms.helpdesk.lesson34.repositories.user_ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserTicketImpl {

    private Connection connection;

    public UserTicketImpl(Connection connection) {
        this.connection = connection;
    }

    public boolean add(Long entityId, String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, entityId);
        int result = preparedStatement.executeUpdate();

        return result != 0;
    }

    public boolean delete(Long entityId, String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query/*UserTicketQueries.deleteTicket()*/);
        preparedStatement.setLong(1, entityId);
        int result = preparedStatement.executeUpdate();

        return result != 0;
    }

}

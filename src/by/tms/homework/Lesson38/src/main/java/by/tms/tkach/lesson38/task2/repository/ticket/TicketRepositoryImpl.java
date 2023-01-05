package by.tms.tkach.lesson38.task2.repository.ticket;

//import by.tms.tkach.lesson38.task1.configs.DbConnection;
//import by.tms.tkach.lesson38.task1.entity.ticket.StatusType;
//import by.tms.tkach.lesson38.task1.entity.ticket.Ticket;

import by.tms.tkach.lesson38.task2.configs.DbConnection;
import by.tms.tkach.lesson38.task2.entity.ticket.StatusType;
import by.tms.tkach.lesson38.task2.entity.ticket.Ticket;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Repository(value = "ticketRepository")
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    private DbConnection connection;

    public TicketRepositoryImpl() {}

    @Override
    public Ticket find(Long id) {

        if (id == null) {
            return null;
        }

        try(Connection connection = getConnection().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.find());
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next() == false) {
                return null;
            } else {
                do{
                    return new Ticket(
                            result.getLong( "id"),
                            result.getString("title"),
                            result.getString("description"),
                            StatusType.valueOf(result.getString("status")),
                            null,
                            null);
                } while (result.next());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}

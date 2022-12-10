package by.tms.helpdesk.lesson34.repositories.ticket;

import by.tms.helpdesk.lesson34.entities.ticket.StatusType;
import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.repositories.Repository;
import by.tms.helpdesk.lesson34.repositories.user_ticket.UserTicketImpl;
import by.tms.helpdesk.lesson34.repositories.user_ticket.UserTicketQueries;
import by.tms.helpdesk.lesson34.utils.log.LogUtil;
import java.sql.*;
import java.util.*;

public class TicketRepositoryImpl implements TicketRepository {

    private final Map<Long, Ticket> TICKET_REPOSITORY = new HashMap<>();

    @Override
    public boolean add(Ticket ticket) {
        boolean resultOfAdding = false;
        if (ticket != null) {
            try(Connection connection = Repository.getConnection()) {
                connection.setAutoCommit(false);
                PreparedStatement insertTicket = connection.prepareStatement(Queries.add(), Statement.RETURN_GENERATED_KEYS);
                insertTicket.setString(1, ticket.getTitle());
                insertTicket.setString(2, ticket.getDescription());
                insertTicket.setString(3, ticket.getStatus().getValue());

                int result = insertTicket.executeUpdate();

                if (result != 0) {
                    Long idOfNewTicket = 0L;
                    ResultSet generatedKeys = insertTicket.getGeneratedKeys();
                    while (generatedKeys.next()) {
                        idOfNewTicket = generatedKeys.getLong(1);
                    }

                    UserTicketImpl userTicket = new UserTicketImpl(connection);
                    resultOfAdding = userTicket.add(idOfNewTicket, UserTicketQueries.addTicket());
                }

                if (resultOfAdding) {
                    connection.commit();
                } else {
                    connection.rollback();
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return resultOfAdding;
    }

    @Override
    public Ticket find(Long id) {

        if (id == null) {
            return null;
        }

        try(Connection connection = Repository.getConnection()) {
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

    public List<Ticket> findByStatus(Long userId, String status) {
        if (userId != null && status != null && !status.isEmpty()) {
            try(Connection connection = Repository.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(Queries.findByStatus());
                preparedStatement.setLong(1, userId);
                preparedStatement.setString(2, status);
                ResultSet result = preparedStatement.executeQuery();

                if (!result.next()) {
                    LogUtil.printInfo("Don't have tickets");
                    return null;
                } else {
                    List<Ticket> foundTickets = new ArrayList<>();
                    do{
                        foundTickets.add(new Ticket(
                                result.getLong( "id"),
                                result.getString("title"),
                                result.getString("description"),
                                StatusType.valueOf(result.getString("status")),
                                null,
                                null));
                    } while (result.next());
                    return foundTickets;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            return null;
        }
    }

    @Override
    public List<Ticket> findAll() {
        try(Connection connection = Repository.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Queries.findAll());

            if (!resultSet.next()) {
                LogUtil.printInfo("Don't have tickets");
                return null;
            } else {
                List<Ticket> foundTickets = new ArrayList<>();
                do {
                    foundTickets.add(new Ticket(
                            resultSet.getLong( "id"),
                            resultSet.getString("title"),
                            resultSet.getString("description"),
                            StatusType.valueOf(resultSet.getString("status")),
                            null,
                            null));
                } while (resultSet.next());
                return foundTickets;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Ticket ticket) {
        boolean resultOfUpdating = false;

        if (ticket == null) {
            LogUtil.printInfo("Ticket object is null");
            return resultOfUpdating;
        }

        try(Connection connection = Repository.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.update());
            preparedStatement.setString(1, ticket.getTitle());
            preparedStatement.setString(2, ticket.getDescription());
            preparedStatement.setString(3, ticket.getStatus().getValue());
            preparedStatement.setLong(4, ticket.getId());

            int updating = preparedStatement.executeUpdate();

            if (updating != 0) {
                resultOfUpdating = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultOfUpdating;
    }

    @Override
    public boolean delete(Long id) {
        boolean resultOfDeleting = false;

        if (id == null) {
            return resultOfDeleting;
        }

        try(Connection connection = Repository.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.delete());
            preparedStatement.setLong(1, id);
            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                UserTicketImpl userTicket = new UserTicketImpl(connection);
                resultOfDeleting = userTicket.delete(id, UserTicketQueries.deleteTicket());
            }

            if (resultOfDeleting) {
                connection.commit();
            } else {
                connection.rollback();
            }
            return resultOfDeleting;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

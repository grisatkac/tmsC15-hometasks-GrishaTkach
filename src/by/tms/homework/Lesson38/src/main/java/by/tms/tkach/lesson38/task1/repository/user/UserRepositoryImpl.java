package by.tms.tkach.lesson38.task1.repository.user;

import by.tms.tkach.lesson38.task1.configs.DbConnection;
import by.tms.tkach.lesson38.task1.entity.role.Role;
import by.tms.tkach.lesson38.task1.entity.role.RoleValues;
import by.tms.tkach.lesson38.task1.entity.ticket.StatusType;
import by.tms.tkach.lesson38.task1.entity.ticket.Ticket;
import by.tms.tkach.lesson38.task1.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Slf4j
@Data
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private DbConnection connection;

    public UserRepositoryImpl() {}

    @Override
    public User find(Long id) {
        User foundUser = null;
        if (id == null) {
            log.info("user id for searching user");

            return foundUser;
        }

        try(Connection connection = getConnection().getConnection()) {
            PreparedStatement insertUser = connection.prepareStatement(Queries.findById());
            insertUser.setLong(1, id);
            ResultSet resultSet= insertUser.executeQuery();

            if (!resultSet.next()) {
                log.info("Don't have user with id " + id);
                return null;
            } else {
                Role role = new Role(RoleValues.valueOf(resultSet.getString("role")));
                role.setId(resultSet.getLong("role.id"));
                foundUser = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("can_do_job"),
                        role,
                        new ArrayList<>()
                );

                do {
                    if ((resultSet.getString("ticket.id") != null)) {
                        Ticket ticket = new Ticket(
                                resultSet.getLong("ticket.id"),
                                resultSet.getString("title"),
                                resultSet.getString("description"),
                                StatusType.valueOf(resultSet.getString("status")),
                                null,
                                null
                        );

                        foundUser.getTickets().add(ticket);
                    }

                } while (resultSet.next());
            }

            return foundUser;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

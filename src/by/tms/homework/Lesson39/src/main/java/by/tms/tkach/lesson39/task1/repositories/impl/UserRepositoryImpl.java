package by.tms.tkach.lesson39.task1.repositories.impl;

import by.tms.tkach.lesson39.task1.configs.DbConnection;
import by.tms.tkach.lesson39.task1.entities.role.Role;
import by.tms.tkach.lesson39.task1.entities.role.RoleValues;
import by.tms.tkach.lesson39.task1.entities.ticket.StatusType;
import by.tms.tkach.lesson39.task1.entities.ticket.Ticket;
import by.tms.tkach.lesson39.task1.entities.user.User;
import by.tms.tkach.lesson39.task1.repositories.role.RoleRepository;
import by.tms.tkach.lesson39.task1.repositories.user.Queries;
import by.tms.tkach.lesson39.task1.repositories.user.UserRepository;
import by.tms.tkach.lesson39.task1.repositories.user_ticket.UserTicketQueries;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier(value = "UserRepository")
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    DbConnection dbConnection;
    UserTicketImpl userTicket;
    RoleRepository roleRepository;

    @Override
    public Boolean create(User user) {
        boolean resultOfAdding = false;

        if (user == null) {
            return resultOfAdding;
        }

        Role role = roleRepository.find(user.getRole());
        User foundUser = find(user.getEmail());

        if (role != null && foundUser == null) {
            try(Connection connection = dbConnection.getConnection()) {
                PreparedStatement insertUser = connection.prepareStatement(Queries.create(), Statement.RETURN_GENERATED_KEYS);
                insertUser.setString(1, user.getName());
                insertUser.setString(2, user.getSurname());
                insertUser.setString(3, user.getEmail());
                insertUser.setString(4, user.getPassword());
                insertUser.setBoolean(5, user.isCanDoJob());
                insertUser.setLong(6, role.getId());

                int result = insertUser.executeUpdate();

                if (result != 0) {
                    resultOfAdding = true;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return resultOfAdding;
    }

    @Override
    public User findById(Long id) {
        User foundUser = null;
        if (id == null) {
            return foundUser;
        }

        try(Connection connection = dbConnection.getConnection()) {
            PreparedStatement insertUser = connection.prepareStatement(Queries.findById());
            insertUser.setLong(1, id);
            ResultSet resultSet= insertUser.executeQuery();

            if (!resultSet.next()) {
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

    @Override
    public User find(String email) {
        User foundUser = null;

        if (email == null || email.isEmpty()) {
            return foundUser;
        }

        try(Connection connection = dbConnection.getConnection()) {
            PreparedStatement foundResult = connection.prepareStatement(Queries.findByEmail());
            foundResult.setString(1, email);

            ResultSet resultSet= foundResult.executeQuery();

            if (!resultSet.next()) {
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
                            new Role(RoleValues.valueOf(resultSet.getString("role"))),
                            new ArrayList<>()
                    );
            }

            return foundUser;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        try(Connection connection = dbConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Queries.findAll());

            if (!resultSet.next()) {
                return null;
            } else {
                List<User> foundUsers = new ArrayList<>();
                do {
                    Role role = new Role(RoleValues.valueOf(resultSet.getString("role")));
                    role.setId(resultSet.getLong("role.id"));
                    foundUsers.add(new User(
                            resultSet.getLong("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getBoolean("can_do_job"),
                            role,
                            null
                    ));
                } while (resultSet.next());
                return foundUsers;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean update(User user) {
        boolean resultOfUpdating = false;

        if (user == null || user.getId() == null) {
            return resultOfUpdating;
        }

        try(Connection connection = dbConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.update());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setBoolean(5, user.isCanDoJob());
            preparedStatement.setLong(6, user.getId());
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
    public Boolean delete(Long id) {
        boolean resultOfDeleting = false;
        if (id == null) {
            return resultOfDeleting;
        }

        try(Connection connection = dbConnection.getConnection() /*RRepository.getConnection()*/) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.delete());
            preparedStatement.setLong(1, id);
            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                //cketImpl userTicket = new UserTicketImpl(dbConnection);
                resultOfDeleting = userTicket.delete(id, UserTicketQueries.deleteUser());
            }

            if (resultOfDeleting) {
                connection.commit();
            } else {
                connection.rollback();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultOfDeleting;
    }

    @Override
    public User login(String email, String password) {
        User candidateUser = null;
        if (email == null || password == null) {
            return candidateUser;
        }
        candidateUser = find(email);

        if (candidateUser == null) {

            return null;
        }

        boolean isCorrectPassword = candidateUser.getPassword().equals(password);

        if (!isCorrectPassword) {
            return null;
        }

        return candidateUser;
    }

    @Override
    public User registrateUser(User user) {
        User newUser = null;
        if (user != null) {
            User existingUser = find(user.getEmail());

            if (existingUser != null) {
                return null;
            }

            boolean resultOfAddingUser = create(user);

            if (resultOfAddingUser) {
                newUser = find(user.getEmail());
            }
        }

        return newUser;
    }

    @Override
    public User logOut(User user) {
        return (user == null)? null : findById(user.getId());
    }
}

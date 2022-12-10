package by.tms.helpdesk.lesson34.repositories.user;

import by.tms.helpdesk.lesson34.entities.role.Role;
import by.tms.helpdesk.lesson34.entities.role.RoleValues;
import by.tms.helpdesk.lesson34.entities.ticket.StatusType;
import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.repositories.Repository;
import by.tms.helpdesk.lesson34.repositories.role.RoleRepository;
import by.tms.helpdesk.lesson34.repositories.role.RoleRepositoryImpl;
import by.tms.helpdesk.lesson34.repositories.user_ticket.UserTicketImpl;
import by.tms.helpdesk.lesson34.repositories.user_ticket.UserTicketQueries;
import by.tms.helpdesk.lesson34.utils.log.LogUtil;
import java.sql.*;
import java.util.*;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public boolean add(User user) {
        boolean resultOfAdding = false;

        if (user == null) {
            return resultOfAdding;
        }

        RoleRepository roleRepository = new RoleRepositoryImpl();
        Role role = roleRepository.find(user.getRole());

        User foundUser = find(user.getEmail());

        if (role != null && foundUser == null) {
            try(Connection connection = Repository.getConnection()) {
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
    public User find(Long id) {
        User foundUser = null;
        if (id == null) {
            LogUtil.printInfo("user id for searching user");
            return foundUser;
        }

        try(Connection connection = Repository.getConnection()) {
            PreparedStatement insertUser = connection.prepareStatement(Queries.findById());
            insertUser.setLong(1, id);
            ResultSet resultSet= insertUser.executeQuery();

            if (!resultSet.next()) {
                LogUtil.printInfo("Don't have user with id " + id);
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

        try(Connection connection = Repository.getConnection()) {
            PreparedStatement foundResult = connection.prepareStatement(Queries.findByEmail());
            foundResult.setString(1, email);

            ResultSet resultSet= foundResult.executeQuery();

            if (!resultSet.next()) {
                LogUtil.printInfo("Don't have user with email " + email);
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
        try(Connection connection = Repository.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Queries.findAll());

            if (!resultSet.next()) {
                LogUtil.printInfo("Don't have users");
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
    public boolean update(User user) {
        boolean resultOfUpdating = false;

        if (user == null || user.getId() == null) {
            LogUtil.printInfo("User object is null");
            return resultOfUpdating;
        }

        try(Connection connection = Repository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.update())) {

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
            LogUtil.printInfo("Incorrect password");
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

            boolean resultOfAddingUser = add(user);

            if (resultOfAddingUser) {
                newUser = find(user.getEmail());
            }
        }

        return newUser;
    }

    @Override
    public User logOut(User user) {
        return (user == null)? null : find(user.getId());
    }
}

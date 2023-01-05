package by.tms.tkach.lesson39.task1.repositories.impl;

import by.tms.tkach.lesson39.task1.configs.DbConnection;
import by.tms.tkach.lesson39.task1.entities.role.Role;
import by.tms.tkach.lesson39.task1.entities.role.RoleValues;
import by.tms.tkach.lesson39.task1.repositories.role.Queries;
import by.tms.tkach.lesson39.task1.repositories.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

    DbConnection dbConnection;

    @Override
    public Boolean create(Role entity) {
        return false;
    }

    @Override
    public Role findById(Long id) {
        return null;
    }

    @Override
    public Role find(Role role) {
        if (role != null) {
            try(Connection connection = dbConnection.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(Queries.findByRoleName());
                preparedStatement.setString(1, role.getRoleValue());
                ResultSet resultSet = preparedStatement.executeQuery();

                if (!resultSet.next()) {
                    return null;
                } else {
                    Role foundRole;
                    do {

                        foundRole = new Role(
                                resultSet.getLong("id"),
                                RoleValues.valueOf(resultSet.getString("role"))
                        );

                        return foundRole;
                    } while (resultSet.next());
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Boolean update(Role entity) {
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        return false;
    }
}

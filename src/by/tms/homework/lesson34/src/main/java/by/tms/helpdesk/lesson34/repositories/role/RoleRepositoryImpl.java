package by.tms.helpdesk.lesson34.repositories.role;

import by.tms.helpdesk.lesson34.entities.role.Role;
import by.tms.helpdesk.lesson34.entities.role.RoleValues;
import by.tms.helpdesk.lesson34.repositories.Repository;
import by.tms.helpdesk.lesson34.utils.log.LogUtil;

import java.sql.*;
import java.util.List;

public class RoleRepositoryImpl implements RoleRepository{
    @Override
    public boolean add(Role entity) {
        return false;
    }

    @Override
    public Role find(Long id) {
        return null;
    }

    @Override
    public Role find(Role role) {
        if (role != null) {
            try(Connection connection = Repository.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(Queries.findByRoleName());
                preparedStatement.setString(1, role.getRoleValue());
                ResultSet resultSet = preparedStatement.executeQuery();

                if (!resultSet.next()) {
                    LogUtil.printInfo("Don't have user with id ");
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
    public boolean update(Role entity) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

}

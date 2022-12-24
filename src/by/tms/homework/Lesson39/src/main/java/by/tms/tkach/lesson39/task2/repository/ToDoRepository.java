package by.tms.tkach.lesson39.task2.repository;

import by.tms.tkach.lesson39.task2.configs.DbConnection;
import by.tms.tkach.lesson39.task2.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Data
@AllArgsConstructor
@Repository
public class ToDoRepository implements CrudRepository<Task> {

    DbConnection connectionDb;

    @Override
    public Boolean add(Task entity) {
        boolean resultOfAdding = false;
        if (entity != null) {
            try(Connection connection = connectionDb.getConnection()) {
                PreparedStatement insertTask = connection.prepareStatement(Query.addTask(), Statement.RETURN_GENERATED_KEYS);
                insertTask.setString(1, entity.getTitle());
                insertTask.setString(2, entity.getDescription());
                insertTask.setString(3, entity.getStatus().getValue());

                int result = insertTask.executeUpdate();

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
    public Boolean update(Task entity) {
        boolean resultOfUpdating = false;

        if (entity == null) {
            return resultOfUpdating;
        }

        try(Connection connection = connectionDb.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.updateStatusTask());
            preparedStatement.setString(1, entity.getStatus().getValue());
            preparedStatement.setString(2, entity.getTitle());
            preparedStatement.setString(3, entity.getDescription());

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
    public Boolean delete(Task entity) {
        boolean resultOfDeleting = false;

        if (entity == null) {
            return resultOfDeleting;
        }

        try(Connection connection = connectionDb.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.deleteTask());
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setString(3, entity.getStatus().getValue());
            int result = preparedStatement.executeUpdate();

            System.out.println(result);
            if (result != 0) {
                resultOfDeleting = true;
            }

            return resultOfDeleting;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

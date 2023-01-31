package by.tms.tkach.lesson48.repositories.user;

import by.tms.tkach.lesson48.entities.Task;
import by.tms.tkach.lesson48.entities.User;
import by.tms.tkach.lesson48.repositories.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User> {
    @Query("SELECT task FROM Task task JOIN FETCH task.user WHERE task.user.id = :id")
    List<Task> getUserTasks(@Param("id") Long id);
}

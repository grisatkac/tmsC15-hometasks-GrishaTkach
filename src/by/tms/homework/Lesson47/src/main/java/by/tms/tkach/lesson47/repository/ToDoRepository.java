package by.tms.tkach.lesson47.repository;

import by.tms.tkach.lesson47.entities.Status;
import by.tms.tkach.lesson47.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByStatusEquals(Status status);

    List<Task> findAllByTitleIgnoreCase(String title);
}

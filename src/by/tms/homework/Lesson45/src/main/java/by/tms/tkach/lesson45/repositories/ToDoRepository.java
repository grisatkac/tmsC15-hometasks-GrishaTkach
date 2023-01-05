package by.tms.tkach.lesson45.repositories;

import by.tms.tkach.lesson45.entities.Task;

public interface ToDoRepository extends CrudRepository<Task> {
    Task updateTitle(Task task);
}

package by.tms.tkach.lesson46.repositories;

import by.tms.tkach.lesson46.entities.Task;

public interface ToDoRepository extends CrudRepository<Task> {
    Task updateTitle(Task task);
}

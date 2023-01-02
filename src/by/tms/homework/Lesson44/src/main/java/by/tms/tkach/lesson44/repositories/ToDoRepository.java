package by.tms.tkach.lesson44.repositories;

import by.tms.tkach.lesson44.entities.Task;

public interface ToDoRepository extends CrudRepository<Task> {
    Task updateTitle(Task task);
}

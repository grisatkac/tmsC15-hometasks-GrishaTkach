package by.tms.tkach.lesson44.services;

import by.tms.tkach.lesson44.entities.Task;

public interface ToDoService extends CrudService<Task> {
    Task updateTitle(Task task);
}

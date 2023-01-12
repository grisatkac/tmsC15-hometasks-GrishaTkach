package by.tms.tkach.lesson46.services;

import by.tms.tkach.lesson46.entities.Task;

public interface ToDoService extends CrudService<Task> {
    Task updateTitle(Task task);
}

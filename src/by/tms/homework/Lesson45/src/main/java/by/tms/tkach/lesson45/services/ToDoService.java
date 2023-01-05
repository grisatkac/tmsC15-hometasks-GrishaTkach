package by.tms.tkach.lesson45.services;

import by.tms.tkach.lesson45.entities.Task;

public interface ToDoService extends CrudService<Task> {
    Task updateTitle(Task task);
}

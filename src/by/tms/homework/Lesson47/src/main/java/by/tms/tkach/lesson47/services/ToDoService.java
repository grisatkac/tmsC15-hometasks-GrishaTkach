package by.tms.tkach.lesson47.services;

import by.tms.tkach.lesson47.entities.Task;

import java.util.List;

public interface ToDoService extends CrudService<Task> {

    List<Task> findByStatus(String status);

    List<Task> findByTitle(String title);
}

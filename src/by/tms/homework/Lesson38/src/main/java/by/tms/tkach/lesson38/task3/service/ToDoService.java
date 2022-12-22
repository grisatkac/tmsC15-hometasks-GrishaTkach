package by.tms.tkach.lesson38.task3.service;

import by.tms.tkach.lesson38.task3.entity.Task;
import by.tms.tkach.lesson38.task3.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToDoService implements CrudService<Task> {

    ToDoRepository repository;

    @Override
    public boolean add(Task entity) {
        boolean isTaskAdded = false;

        if (entity == null) {
            return isTaskAdded;
        }

        repository.add(entity);

        return isTaskAdded;
    }

    @Override
    public boolean update(Task entity) {

        boolean resultOfUpdating = false;

        if (entity == null) {
            return resultOfUpdating;
        }

        resultOfUpdating = repository.update(entity);
        return resultOfUpdating;
    }

    @Override
    public boolean delete(Task entity) {
        boolean resultOfDeleting = false;

        if (entity == null) {
            return resultOfDeleting;
        }

        resultOfDeleting = repository.delete(entity);
        return resultOfDeleting;
    }
}

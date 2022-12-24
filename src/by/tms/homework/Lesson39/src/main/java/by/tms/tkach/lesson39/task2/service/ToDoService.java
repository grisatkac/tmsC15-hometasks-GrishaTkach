package by.tms.tkach.lesson39.task2.service;

import by.tms.tkach.lesson39.task2.entity.Task;
import by.tms.tkach.lesson39.task2.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class ToDoService implements CrudService<Task> {

    ToDoRepository repository;

    @Override
    public Boolean add(Task entity) {
        Boolean isTaskAdded = false;

        if (entity == null) {
            return isTaskAdded;
        }

        isTaskAdded = repository.add(entity);

        return isTaskAdded;
    }

    @Override
    public Boolean update(Task entity) {

        boolean resultOfUpdating = false;

        if (entity == null) {
            return resultOfUpdating;
        }

        resultOfUpdating = repository.update(entity);
        return resultOfUpdating;
    }

    @Override
    public Boolean delete(Task entity) {
        boolean resultOfDeleting = false;

        if (entity == null) {
            return resultOfDeleting;
        }

        resultOfDeleting = repository.delete(entity);
        return resultOfDeleting;
    }
}

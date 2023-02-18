package by.tms.tkach.lesson46.services.impl;

import by.tms.tkach.lesson46.entities.Task;
import by.tms.tkach.lesson46.repositories.ToDoRepository;
import by.tms.tkach.lesson46.services.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    @Override
    public Task create(Task task) {
        return toDoRepository.create(task);
    }

    @Override
    public List<Task> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return toDoRepository.findById(id).orElse(null);
    }

    @Override
    public Task update(Task task) {
        findById(task.getId());
        return toDoRepository.update(task);
    }

    @Override
    public Task updateTitle(Task task) {
        toDoRepository.updateTitle(task);
        return findById(task.getId());
    }

    @Override
    public void delete(Long id) {
        findById(id);
        toDoRepository.delete(id);
    }
}

package by.tms.tkach.lesson47.services.impl;

import by.tms.tkach.lesson47.entities.Status;
import by.tms.tkach.lesson47.entities.Task;
import by.tms.tkach.lesson47.repository.ToDoRepository;
import by.tms.tkach.lesson47.services.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import java.util.List;

@Service
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    @Override
    public Task create(Task task) {
        return toDoRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return toDoRepository.findById(id).orElseThrow(() -> new ResourceAccessException(String.format("Cannot find user with id '%s'", id)));
    }

    @Override
    public List<Task> findByStatus(String status) {
        return toDoRepository.findAllByStatusEquals(Status.valueOf(status));
    }

    @Override
    public List<Task> findByTitle(String title) {
        return toDoRepository.findAllByTitleIgnoreCase(title);
    }

    @Override
    public Task update(Task task) {
        findById(task.getId());
        return toDoRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        toDoRepository.deleteById(id);
    }

    @Override
    public void delete(Task task) {
        findById(task.getId());
        toDoRepository.delete(task);
    }
}

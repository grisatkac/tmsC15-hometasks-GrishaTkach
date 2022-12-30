package by.tms.tkach.lesson43.services.impl;

import by.tms.tkach.lesson43.entities.Status;
import by.tms.tkach.lesson43.entities.Task;
import by.tms.tkach.lesson43.repositories.ToDoRepository;
import by.tms.tkach.lesson43.services.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    @Override
    public Task create(Task task) {
        task.setStatus(Status.TO_DO);
        return toDoRepository.create(task);
    }

    @Override
    public List<Task> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return toDoRepository.findById(id);
    }
}

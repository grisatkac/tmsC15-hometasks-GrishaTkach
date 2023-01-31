package by.tms.tkach.lesson48.services.task;

import by.tms.tkach.lesson48.dto.task.TaskSimpleDTO;
import by.tms.tkach.lesson48.mappers.TaskMapper;
import by.tms.tkach.lesson48.repositories.task.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskSimpleDTO save(TaskSimpleDTO task) {
        return taskMapper.toTaskSimpleDTO(taskRepository.save(taskMapper.toTask(task)));
    }

    @Override
    public List<TaskSimpleDTO> findAll() {
        return taskMapper.toTaskSimpleDTOList(taskRepository.findAll());
    }

    @Override
    public TaskSimpleDTO findById(Long id) {
        return taskMapper.toTaskSimpleDTO(taskRepository.findById(id));
    }

    @Override
    public TaskSimpleDTO update(TaskSimpleDTO value) {
        return taskMapper.toTaskSimpleDTO(taskRepository.update(taskMapper.toTask(value)));
    }

    @Override
    public void delete(Long id) {
        taskRepository.delete(id);
    }
}

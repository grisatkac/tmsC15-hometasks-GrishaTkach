package by.tms.tkach.lesson48.mappers;

import by.tms.tkach.lesson48.dto.task.TaskSimpleDTO;
import by.tms.tkach.lesson48.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(source = "status", target = "status")
    TaskSimpleDTO toTaskSimpleDTO(Task task);
    List<TaskSimpleDTO> toTaskSimpleDTOList(List<Task> tasks);
    @Mapping(source = "status", target = "status")
    Task toTask(TaskSimpleDTO taskSimpleDTO);
    @Mapping(source = "status", target = "status")
    Task taskToTask(Task task);
    List<Task> toTaskList(List<TaskSimpleDTO> tasks);
}

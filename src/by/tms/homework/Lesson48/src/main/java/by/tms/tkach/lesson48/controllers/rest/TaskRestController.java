package by.tms.tkach.lesson48.controllers.rest;

import by.tms.tkach.lesson48.dto.task.TaskDTO;
import by.tms.tkach.lesson48.dto.task.TaskSimpleDTO;
import by.tms.tkach.lesson48.services.task.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/task")
@AllArgsConstructor
public class TaskRestController {

    private TaskService taskService;

    @GetMapping("{id}")
    @Operation(summary = "Get task by id")
    public TaskDTO findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Get all tasks")
    public List<TaskSimpleDTO> findAll() {
        return taskService.findAll();
    }

    @PostMapping("/create")
    @Operation(summary = "Create task")
    public TaskSimpleDTO create(@RequestBody TaskSimpleDTO taskSimpleDTO) {
        return taskService.save(taskSimpleDTO);
    }

    @PutMapping
    @Operation(summary = "Update task")
    public TaskSimpleDTO update(@RequestBody TaskSimpleDTO user) {
        return taskService.update(user);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete task by id")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}

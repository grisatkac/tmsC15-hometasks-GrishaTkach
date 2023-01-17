package by.tms.tkach.lesson47.controllers.rest;

import by.tms.tkach.lesson47.entities.Task;
import by.tms.tkach.lesson47.services.ToDoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Tag(name = "ToDo", description = "ToDo API")
@RestController
@RequestMapping("rest/todo")
@AllArgsConstructor
public class ToDoRestController {

    private final ToDoService toDoService;

    @GetMapping("/all")
    @Operation(summary = "Get all tasks")
    public List<Task> findAll() {
        return toDoService.findAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get task by id")
    public Task findById(@PathVariable Long id) {
        return toDoService.findById(id);
    }

    @GetMapping("/byStatus/{status}")
    @Operation(summary = "get tasks by status")
    public List<Task> findByStatus(@PathVariable String status) {
        return toDoService.findByStatus(status);
    }

    @GetMapping("/byTitle/{title}")
    @Operation List<Task> findByTitle(@PathVariable String title) {
        return toDoService.findByTitle(title);
    }

    @PostMapping("/create")
    @Operation(summary = "Create task")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Task task) {
        toDoService.create(task);
    }

    @PutMapping
    @Operation(summary = "Update all fields of task using put method")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Task update(@RequestBody Task task) {
        return toDoService.update(task);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete task by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        toDoService.deleteById(id);
    }
}

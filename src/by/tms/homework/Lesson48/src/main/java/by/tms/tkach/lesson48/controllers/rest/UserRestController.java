package by.tms.tkach.lesson48.controllers.rest;

import by.tms.tkach.lesson48.dto.task.TaskSimpleDTO;
import by.tms.tkach.lesson48.dto.user.UserDTO;
import by.tms.tkach.lesson48.dto.user.UserSimpleDTO;
import by.tms.tkach.lesson48.dto.userTask.TaskToUserDTO;
import by.tms.tkach.lesson48.entities.Task;
import by.tms.tkach.lesson48.entities.User;
import by.tms.tkach.lesson48.mappers.TaskMapper;
import by.tms.tkach.lesson48.services.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("rest/users")
@AllArgsConstructor
public class UserRestController {

    private UserService userService;
    private TaskMapper taskMapper;

    @GetMapping("{id}")
    @Operation(summary = "Get user by id")
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public List<UserSimpleDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping("/create")
    @Operation(summary = "Create user")
    public UserDTO create(@RequestBody UserSimpleDTO user) {
        return userService.save(user);
    }

    @PutMapping
    @Operation(summary = "Update user")
    public UserDTO update(@RequestBody UserSimpleDTO user) {
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete user by id")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("{id}/tasks")
    @Operation(summary = "Get user tasks by id")
    public List<TaskSimpleDTO> findTasksByUserId(@PathVariable Long id) {
        return userService.getUserTasks(id);
    }

    @PostMapping("tasks/assign")
    @Operation(summary = "Assign task to user")
    public void assignTaskToUser(@RequestBody TaskToUserDTO taskUserDTO) {
        userService.assignTaskToUser(taskUserDTO.getUserId(), taskUserDTO.getTask());
    }

    @GetMapping("/page")
    public Page<User> getByPage(Pageable pageable) {
        return userService.getByPage(pageable);
    }
}

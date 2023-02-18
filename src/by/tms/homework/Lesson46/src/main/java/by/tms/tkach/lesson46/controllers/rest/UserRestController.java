package by.tms.tkach.lesson46.controllers.rest;

import by.tms.tkach.lesson46.entities.User;
import by.tms.tkach.lesson46.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "user", description = "User API")
@RestController
@RequestMapping("rest/users")
@AllArgsConstructor
public class UserRestController {

    private UserService userService;

    @GetMapping("{id}")
    @Operation(summary = "Get user by id")
    public User findById(@PathVariable  Long id) {
        return userService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/create")
    @Operation(summary = "Create user")
    public User create(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    @Operation(summary = "Update user")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete user by id")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}

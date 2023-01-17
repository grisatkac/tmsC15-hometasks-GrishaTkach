package by.tms.tkach.lesson47.controllers.rest;

import by.tms.tkach.lesson47.entities.User;
import by.tms.tkach.lesson47.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/firstName")
    @Operation(summary = "get one user by first name")
    public User findOneByFirstName(@RequestParam String firstName) {
        return userService.findByFirstName(firstName);
    }

    @GetMapping("/lastName")
    @Operation(summary = "get one user by last name")
    public User findOneByLastName(@RequestParam String lastName) {
        return userService.findByLastName(lastName);
    }

    @PostMapping("/create")
    @Operation(summary = "Create user")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    @Operation(summary = "Update user")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "Delete user by id")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }
}

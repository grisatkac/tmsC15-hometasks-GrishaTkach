package by.tms.tkach.lesson43.controllers;

import by.tms.tkach.lesson43.entities.Student;
import by.tms.tkach.lesson43.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Student", description = "Student API")
@RestController
@RequestMapping("rest/students")
@AllArgsConstructor
public class StudentRestController {

    private final StudentService studentService;

    @PostMapping
    @Operation(summary = "Create student")
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all students")
    public List<Student> findAll(Model model) {
        return studentService.findAll();
    }

}

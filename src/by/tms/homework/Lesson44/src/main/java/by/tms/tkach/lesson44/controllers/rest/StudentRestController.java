package by.tms.tkach.lesson44.controllers.rest;

import by.tms.tkach.lesson44.entities.Student;
import by.tms.tkach.lesson44.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Student", description = "Student API")
@RestController
@RequestMapping("rest/students")
@AllArgsConstructor
public class StudentRestController {

    private final StudentService studentService;

    @PostMapping
    @Operation(summary = "Create student")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Student student) {
        studentService.create(student);
    }

    @GetMapping("{id}")
    @Operation(summary = "get student by id")
    public Student getById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PatchMapping
    @Operation(summary = "Update student fields using put method")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student patch(@RequestBody Student student) {
        return studentService.updateFirstName(student);
    }

    @PutMapping
    @Operation(summary = "Update student fields")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student updatedStudent = studentService.update(student);
        return ResponseEntity.accepted()
                .body(updatedStudent);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}

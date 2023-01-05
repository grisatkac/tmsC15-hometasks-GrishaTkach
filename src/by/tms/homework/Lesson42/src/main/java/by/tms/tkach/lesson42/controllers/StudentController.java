package by.tms.tkach.lesson42.controllers;

import by.tms.tkach.lesson42.entities.Student;
import by.tms.tkach.lesson42.services.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @ModelAttribute("student")
    public Student getStudent() {
        return Student.builder().build();
    }

    @GetMapping("/form")
    public String userForm() {
        return "student/form";
    }

    @PostMapping("/form")
    public String createStudent(@Valid Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "student/form";
        }

        studentService.create(student);
        return "redirect:/students/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/students";
    }
}

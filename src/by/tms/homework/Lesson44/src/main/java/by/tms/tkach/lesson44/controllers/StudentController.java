package by.tms.tkach.lesson44.controllers;

import by.tms.tkach.lesson44.entities.Student;
import by.tms.tkach.lesson44.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
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

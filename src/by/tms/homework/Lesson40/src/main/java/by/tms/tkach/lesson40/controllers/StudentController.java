package by.tms.tkach.lesson40.controllers;

import by.tms.tkach.lesson40.entities.Student;
import by.tms.tkach.lesson40.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/form")
    public String userForm(Model model) {
        model.addAttribute("student", Student.builder().build());
        return "student/form";
    }

    @PostMapping("/form")
    public String createStudent(@ModelAttribute("student") Student student) {
        System.out.println("receive student object from form: ");
        System.out.println(student);
        studentService.create(student);
        return "redirect:/students/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/students";
    }
}

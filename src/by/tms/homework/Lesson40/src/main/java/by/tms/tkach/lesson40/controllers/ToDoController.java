package by.tms.tkach.lesson40.controllers;

import by.tms.tkach.lesson40.entities.Task;
import by.tms.tkach.lesson40.services.ToDoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping("/form")
    public String todoForm(Model model) {
        model.addAttribute("task", Task.builder().build());
        return "todo/form";
    }

    @PostMapping("/form")
    public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult) {
        toDoService.create(task);

        if (bindingResult.hasErrors()) {
            return "todo/form";
        }

        return "redirect:/todo/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("tasks", toDoService.findAll());
        return "todo/tasks";
    }
}

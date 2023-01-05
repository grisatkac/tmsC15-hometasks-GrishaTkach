package by.tms.tkach.lesson40.controllers;

import by.tms.tkach.lesson40.entities.Task;
import by.tms.tkach.lesson40.services.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String createTask(@ModelAttribute("task") Task task) {
        toDoService.create(task);
        return "redirect:/todo/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        System.out.println("TO DO ALL");
        List<Task> klist = toDoService.findAll();
        System.out.println(klist);
        model.addAttribute("tasks", toDoService.findAll());
        return "todo/tasks";
    }
}

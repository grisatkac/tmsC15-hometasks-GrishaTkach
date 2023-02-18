package by.tms.tkach.lesson47.controllers;

import by.tms.tkach.lesson47.entities.Task;
import by.tms.tkach.lesson47.services.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService toDoService;


    @GetMapping("/form")
    public String todoForm() {
        return "todo/form";
    }

    @PostMapping("/form")
    public String createTask(@Valid Task task, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "todo/form";
        }

         toDoService.create(task);
         return "redirect:/todo/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("tasks", toDoService.findAll());
        return "todo/tasks";
    }
}

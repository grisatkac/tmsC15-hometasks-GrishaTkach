package by.tms.tkach.lesson39.task2;

import by.tms.tkach.lesson39.task2.entity.Status;
import by.tms.tkach.lesson39.task2.entity.Task;
import by.tms.tkach.lesson39.task2.service.ToDoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("by.tms.tkach.lesson39.task2");
        ToDoService toDoService = applicationContext.getBean("toDoService", ToDoService.class);
        Task newTask = Task.builder()
                        .title("new title")
                        .description("new description")
                        .status(Status.IN_PROGRESS)
                        .build();
        toDoService.add(newTask);

    }
}

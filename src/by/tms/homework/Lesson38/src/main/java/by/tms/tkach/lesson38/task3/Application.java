package by.tms.tkach.lesson38.task3;

import by.tms.tkach.lesson38.task3.configs.ApplicationConfig;
import by.tms.tkach.lesson38.task3.entity.Task;
import by.tms.tkach.lesson38.task3.service.ToDoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ToDoService toDoService = applicationContext.getBean("toDoService", ToDoService.class);
        Task task = applicationContext.getBean("task", Task.class);

        toDoService.add(task);

        Task taskForUpdateStatus = applicationContext.getBean("taskForUpdateStatus", Task.class);
        toDoService.update(taskForUpdateStatus);

        toDoService.add(task);
        toDoService.delete(task);
    }
}

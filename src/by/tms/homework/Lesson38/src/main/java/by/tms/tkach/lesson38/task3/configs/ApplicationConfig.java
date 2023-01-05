package by.tms.tkach.lesson38.task3.configs;

import by.tms.tkach.lesson38.task3.entity.Status;
import by.tms.tkach.lesson38.task3.entity.Task;
import by.tms.tkach.lesson38.task3.repository.ToDoRepository;
import by.tms.tkach.lesson38.task3.service.ToDoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("by.tms.tkach.lesson38.task3")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {


    @Bean
    public Status toDoStatus() {
        return Status.TO_DO;
    }

    @Bean
    public Status inProgressStatus() {
        return Status.TO_DO;
    }

    @Bean
    public Status doneStatus() {
        return Status.DONE;
    }

    @Bean
    public Task task() {
        return Task.builder()
                .title("title")
                .description("description")
                .status(toDoStatus())
                .build();
    }

    @Bean
    public Task taskForAdding() {
        return Task.builder()
                .title("new title")
                .description("new description")
                .status(toDoStatus())
                .build();
    }

    @Bean
    public Task taskForUpdateStatus() {
        return Task.builder()
                .title("title")
                .description("description")
                .status(doneStatus())
                .build();
    }

    @Bean
    DbConnection connection() {
        return new DbConnection();
    }

    @Bean
    ToDoRepository toDoRepository() {
        return new ToDoRepository(connection());
    }

    @Bean
    ToDoService toDoService() {
        return new ToDoService(toDoRepository());
    }
}

package by.tms.tkach.lesson43.repositories.impl;

import by.tms.tkach.lesson43.entities.Task;
import by.tms.tkach.lesson43.mappers.TaskMapper;
import by.tms.tkach.lesson43.repositories.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@AllArgsConstructor
public class ToDoRepositoryImpl implements ToDoRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public Task create(Task task) {
        jdbcTemplate.update("INSERT INTO task(title, description, status) VALUES (?, ?, ?);",
                task.getTitle(),
                task.getDescription(),
                task.getStatus().getValue());
        return task;
    }

    @Override
    public List<Task> findAll() {
        Stream<Task> stream = jdbcTemplate.queryForStream("SELECT * FROM task", new TaskMapper());
        return stream.collect(Collectors.toList());
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(
                jdbcTemplate.queryForObject("SELECT * FROM task WHERE id=?;",
                        new BeanPropertyRowMapper<>(Task.class),
                        id));
    }
}

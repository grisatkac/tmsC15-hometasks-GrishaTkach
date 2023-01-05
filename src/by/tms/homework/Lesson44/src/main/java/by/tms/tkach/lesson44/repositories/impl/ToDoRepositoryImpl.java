package by.tms.tkach.lesson44.repositories.impl;

import by.tms.tkach.lesson44.entities.Status;
import by.tms.tkach.lesson44.entities.Task;
import by.tms.tkach.lesson44.exceptions.ResourceNotFoundException;
import by.tms.tkach.lesson44.repositories.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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
                Status.TO_DO);
        return task;
    }

    @Override
    public List<Task> findAll() {
        Stream<Task> stream = jdbcTemplate.queryForStream("SELECT * FROM task",
                new BeanPropertyRowMapper<>(Task.class));
        return stream.collect(Collectors.toList());
    }

    @Override
    public Optional<Task> findById(Long id) {
        Optional<Task> task;
        try {
            task = Optional.ofNullable(
                    jdbcTemplate.queryForObject("SELECT * FROM task WHERE id=?;",
                            new BeanPropertyRowMapper<>(Task.class), id));

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(String.format("Can't find task in task repository with id: %s", id));
        }
        return task;
    }

    @Override
    public Task update(Task task) {
        jdbcTemplate.update("UPDATE task SET title=?, description=?;", task.getTitle(), task.getDescription(), task.getStatus().name());
        return task;
    }

    @Override
    public Task updateTitle(Task task) {
        jdbcTemplate.update("UPDATE task SET title=? WHERE id=?;", task.getTitle(), task.getId());
        return task;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM task WHERE id=?;", id);
    }
}

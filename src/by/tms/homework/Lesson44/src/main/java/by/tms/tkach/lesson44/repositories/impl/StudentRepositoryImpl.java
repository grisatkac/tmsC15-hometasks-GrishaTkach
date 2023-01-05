package by.tms.tkach.lesson44.repositories.impl;

import by.tms.tkach.lesson44.entities.Student;
import by.tms.tkach.lesson44.exceptions.ResourceNotFoundException;
import by.tms.tkach.lesson44.repositories.StudentRepository;
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
public class StudentRepositoryImpl implements StudentRepository {

    private JdbcTemplate jdbcTemplate;
    @Override
    public Student create(Student student) {
        jdbcTemplate.update("INSERT INTO students(first_name, last_name, number) VALUES (?, ?, ?);",
                student.getFirstName(),
                student.getLastName(),
                student.getNumber());
        return student;
    }

    @Override
    public List<Student> findAll() {
        Stream<Student> stream = jdbcTemplate.queryForStream("SELECT * FROM students;",
                new BeanPropertyRowMapper<>(Student.class));
        return stream.collect(Collectors.toList());
    }

    @Override
    public Optional<Student> findById(Long id) {
        Optional<Student> student;
        try {
             student = Optional.ofNullable(
                    jdbcTemplate.queryForObject("SELECT * FROM students WHERE id=?;",
                            new BeanPropertyRowMapper<>(Student.class), id));

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Can't find task in student repository with id: " + id);
        }
        return student;
    }

    @Override
    public Student update(Student student) {
        jdbcTemplate.update("UPDATE students SET first_name=?, last_name=?, number=? WHERE id=?;", student.getFirstName(), student.getLastName(), student.getNumber(), student.getId());
        return student;
    }

    @Override
    public Student updateFirstName(Student student) {
        jdbcTemplate.update("UPDATE students SET first_name=? WHERE id=?;", student.getFirstName(), student.getId());
        return student;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM students WHERE id=?;", id);
    }


}

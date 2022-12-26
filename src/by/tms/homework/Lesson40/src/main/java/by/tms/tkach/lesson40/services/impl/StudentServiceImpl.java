package by.tms.tkach.lesson40.services.impl;

import by.tms.tkach.lesson40.entities.Student;
import by.tms.tkach.lesson40.repositories.StudentRepository;
import by.tms.tkach.lesson40.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        return studentRepository.create(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }
}

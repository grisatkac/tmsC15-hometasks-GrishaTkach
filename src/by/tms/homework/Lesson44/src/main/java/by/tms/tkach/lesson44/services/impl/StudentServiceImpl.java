package by.tms.tkach.lesson44.services.impl;

import by.tms.tkach.lesson44.entities.Student;
import by.tms.tkach.lesson44.repositories.StudentRepository;
import by.tms.tkach.lesson44.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.findById(id);
        studentRepository.delete(id);
    }

    @Override
    public Student updateFirstName(Student student) {
        return studentRepository.updateFirstName(student);
    }
}

package by.tms.tkach.lesson45.services.impl;

import by.tms.tkach.lesson45.entities.Student;
import by.tms.tkach.lesson45.exceptions.ResourceNotFoundException;
import by.tms.tkach.lesson45.repositories.StudentRepository;
import by.tms.tkach.lesson45.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        List<Student> students = studentRepository.findAll();

        if (CollectionUtils.isEmpty(students)) {
            throw new ResourceNotFoundException("Cannot find students");
        }

        return students;
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

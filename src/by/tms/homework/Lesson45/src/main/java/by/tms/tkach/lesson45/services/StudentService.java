package by.tms.tkach.lesson45.services;

import by.tms.tkach.lesson45.entities.Student;

public interface StudentService extends CrudService<Student>{

    Student updateFirstName(Student student);
}

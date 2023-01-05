package by.tms.tkach.lesson44.services;

import by.tms.tkach.lesson44.entities.Student;

public interface StudentService extends CrudService<Student>{

    Student updateFirstName(Student student);
}

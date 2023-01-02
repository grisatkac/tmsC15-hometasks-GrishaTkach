package by.tms.tkach.lesson44.repositories;

import by.tms.tkach.lesson44.entities.Student;

public interface StudentRepository extends CrudRepository<Student> {
    Student updateFirstName(Student student);
}

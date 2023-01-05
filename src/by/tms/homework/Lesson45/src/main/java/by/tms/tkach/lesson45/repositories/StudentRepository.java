package by.tms.tkach.lesson45.repositories;

import by.tms.tkach.lesson45.entities.Student;

public interface StudentRepository extends CrudRepository<Student> {
    Student updateFirstName(Student student);
}

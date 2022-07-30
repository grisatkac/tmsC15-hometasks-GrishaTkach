package by.tms.homework.lesson13.task4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskDemo {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Pasha", "Pashov", 15, 7.5));
        studentList.add(new Student("Alex", "Alexandrov", 15, 8.3));
        studentList.add(new Student("Vasil", "Vasilev", 14, 9.7));
        studentList.add(new Student("Hakim", "Nishe", 17, 9.7));
        studentList.add(new Student("Alex", "Suleimanov", 15, 8.3));
        studentList.add(new Student("Alex", "Suleimanov", 16, 8.3));
        studentList.add(new Student("Aalex", "Alexandrov", 15, 8.3));

        System.out.println(getStudentWithTheBiggerAverageGrade(studentList));
        sortListOfStudents(studentList);
        System.out.println(studentList);
    }

    public static Student getStudentWithTheBiggerAverageGrade(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return new Student("", "", 0, 0);
        }

        Student studentWithMaxAverageGrade = new Student("", "", 0, 0);

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() > studentWithMaxAverageGrade.getAverageGrade()) {
                studentWithMaxAverageGrade = student;
            }
        }
        return studentWithMaxAverageGrade;
    }

    public static void sortListOfStudents(List<Student> students) {
        students.sort(new StudentComparator());
    }
}

package by.tms.homework.lesson13.task4;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student first, Student second) {
        int resultFirstName = first.getFirstName().compareTo(second.getFirstName());
        int resultLastName = first.getLastName().compareTo(second.getLastName());
        int resultAge = Integer.compare(first.getAge(), second.getAge());
        int resultAverageGrade = Double.compare(first.getAverageGrade(), second.getAverageGrade());
        return !(resultFirstName == 0)? resultFirstName :
                (resultLastName == 0)? resultLastName :
                (resultAge == 0)? resultAge :resultAverageGrade;
    }
}

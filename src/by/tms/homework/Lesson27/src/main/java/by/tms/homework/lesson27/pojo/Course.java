package by.tms.homework.lesson27.pojo;

import by.tms.homework.lesson27.utils.IdentityUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Course implements Serializable {

    private static final long serialVersionUID = 65123123L;
    private long id;
    private CourseName name;
    private int price;
    private int maximumAmountOfStudents;

    public Course(CourseName name, int price, int maximumAmountOfStudents) {
        this.id = IdentityUtil.getId();
        this.name = name;
        this.price = price;
        this.maximumAmountOfStudents = maximumAmountOfStudents;
    }

    public long getId() {
        return id;
    }

    public CourseName getName() {
        return name;
    }

    public void setName(CourseName name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getMaximumAmountOfStudents() {
        return maximumAmountOfStudents;
    }

    public void setMaximumAmountOfStudents(int maximumAmountOfStudents) {
        this.maximumAmountOfStudents = maximumAmountOfStudents;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && price == course.price &&  maximumAmountOfStudents == course.maximumAmountOfStudents && name == course.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, maximumAmountOfStudents);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", maximumAmountOfStudents=" + maximumAmountOfStudents +
                '}';
    }
}

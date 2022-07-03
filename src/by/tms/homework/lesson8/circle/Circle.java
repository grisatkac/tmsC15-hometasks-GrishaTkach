package by.tms.homework.lesson8.circle;

import by.tms.homework.lesson6.Point;

import java.util.Objects;

public final class Circle extends Cycle {

    public Circle(Point center, double radius) {
        super(center, radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Objects.equals(center, circle.center);
    }

    @Override
    public double squareOfShape() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calcLengthOfRound() {
        return 2 * Math.PI * radius;
    }
}

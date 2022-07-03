package by.tms.homework.lesson8.triangle;

import by.tms.homework.lesson6.Point;
import by.tms.homework.lesson8.IShape;

import java.util.Objects;

public abstract class Triangle implements IShape, ITriangle {

    protected double firstSide;
    protected double secondSide;
    protected double thirdSide;

    public Triangle() {}

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstSide = firstPoint.distance(secondPoint);
        this.secondSide = secondPoint.distance(thirdPoint);
        this.thirdSide = thirdPoint.distance(firstPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.firstSide, firstSide) == 0 && Double.compare(triangle.secondSide, secondSide) == 0 && Double.compare(triangle.thirdSide, thirdSide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstSide, secondSide, thirdSide);
    }

    @Override
    public final boolean equalsArea(IShape shape) {
        return squareOfShape() == shape.squareOfShape();
    }

    @Override
    public final double perimeterOfShape() {
        return firstSide + secondSide + thirdSide;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(double firstSide) {
        this.firstSide = firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(double secondSide) {
        this.secondSide = secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }

    public void setThirdSide(double thirdSide) {
        this.thirdSide = thirdSide;
    }
}

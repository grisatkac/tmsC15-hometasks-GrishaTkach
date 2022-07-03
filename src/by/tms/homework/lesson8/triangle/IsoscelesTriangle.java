package by.tms.homework.lesson8.triangle;

import by.tms.homework.lesson6.Point;

import java.util.Objects;

/*
 * class IsoscelesTriangle
 *
 * firstSide - left side
 * secondSide - right side(firstSide == secondSide)
 * thirdSide - bottom side
 */

public final class IsoscelesTriangle extends Triangle {

    public IsoscelesTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        super(firstPoint, secondPoint, thirdPoint);
    }

    @Override
    public String toString() {
        return "IsoscelesTriangle{" +
                "firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", thirdSide=" + thirdSide +
                '}';
    }

    @Override
    public double squareOfShape() {
        return 0.5 * firstSide * calcHeightTriangle();
    }

    @Override
    public double calcHeightTriangle() {
        return Math.sqrt(Math.pow(firstSide, 2) - Math.pow(thirdSide / 2, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsoscelesTriangle isoscelesTriangle = (IsoscelesTriangle) o;
        return Double.compare(isoscelesTriangle.firstSide, firstSide) == 0 && Double.compare(isoscelesTriangle.secondSide, secondSide) == 0 && Double.compare(isoscelesTriangle.thirdSide, thirdSide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstSide, secondSide, thirdSide);
    }
}

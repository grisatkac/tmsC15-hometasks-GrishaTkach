package by.tms.homework.lesson8.triangle;

import by.tms.homework.lesson6.Point;

import java.util.Objects;

/*
 * class RectangularTriangle
 *
 * firstSide - katet
 * secondSide - second katet
 * thirdSide - gypotenuza
 */

public final class RectangularTriangle extends Triangle {

    public RectangularTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        super(firstPoint, secondPoint, thirdPoint);
    }

    @Override
    public double squareOfShape() {
        return 0.5 * firstSide * secondSide;
    }

    @Override
    public double calcHeightTriangle() {
        return firstSide * secondSide / thirdSide;
    }

    @Override
    public String toString() {
        return "RectangularTriangle{" +
                "firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", thirdSide=" + thirdSide +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectangularTriangle rectangularTriangle = (RectangularTriangle) o;
        return Double.compare(rectangularTriangle.firstSide, firstSide) == 0 && Double.compare(rectangularTriangle.secondSide, secondSide) == 0 && Double.compare(rectangularTriangle.thirdSide, thirdSide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstSide, secondSide, thirdSide);
    }
}

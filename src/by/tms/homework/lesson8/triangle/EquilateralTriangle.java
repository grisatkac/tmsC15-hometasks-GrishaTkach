package by.tms.homework.lesson8.triangle;

import by.tms.homework.lesson6.Point;

import java.util.Objects;

/*
 * class EquilateralTriangle
 *
 * firstSide = secondSide = thirdSide
 */

public final class EquilateralTriangle extends Triangle {

    public EquilateralTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        super(firstPoint, secondPoint, thirdPoint);
    }

    @Override
    public double squareOfShape() {
        return (Math.sqrt(3) / 4) * Math.pow(firstSide, 2);
    }

    @Override
    public double calcHeightTriangle() {
        return Math.sqrt(3 * squareOfShape() / Math.sqrt(3));
    }

    @Override
    public String toString() {
        return "EquilateralTriangle{" +
                "firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", thirdSide=" + thirdSide +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquilateralTriangle equilateralTriangle = (EquilateralTriangle) o;
        return Double.compare(equilateralTriangle.firstSide, firstSide) == 0 && Double.compare(equilateralTriangle.secondSide, secondSide) == 0 && Double.compare(equilateralTriangle.thirdSide, thirdSide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstSide, secondSide, thirdSide);
    }
}

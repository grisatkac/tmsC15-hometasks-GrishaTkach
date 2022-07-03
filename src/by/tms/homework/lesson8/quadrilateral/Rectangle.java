package by.tms.homework.lesson8.quadrilateral;

import by.tms.homework.lesson6.Point;

public final class Rectangle extends Quadrilateral {

    public Rectangle(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        super(firstPoint, secondPoint, thirdPoint, fourthPoint);
    }

    @Override
    public double squareOfShape() {
        return firstSide * secondSide;
    }

    @Override
    public double perimeterOfShape() {
        return (firstSide + secondSide) * 2;
    }

    @Override
    public double calcQuadrilateralDiagonal() {
        return Math.sqrt(Math.pow(firstSide, 2) + Math.pow(secondSide, 2));
    }
}

package by.tms.homework.lesson8.quadrilateral;

import by.tms.homework.lesson6.Point;

public class Square extends Quadrilateral {

    public Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        super(firstPoint, secondPoint, thirdPoint, fourthPoint);
    }

    @Override
    public double squareOfShape() {
        return firstSide * 2;
    }

    @Override
    public double perimeterOfShape() {
        return firstSide * 4;
    }

    @Override
    public double calcQuadrilateralDiagonal() {
        return Math.sqrt(2) * firstSide;
    }
}

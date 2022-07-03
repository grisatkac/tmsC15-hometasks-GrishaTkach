package by.tms.homework.lesson8.quadrilateral;

import by.tms.homework.lesson6.Point;
import by.tms.homework.lesson8.IShape;

public abstract class Quadrilateral implements IShape, IQuadrilateral {

    protected double firstSide;
    protected double secondSide;
    protected double thirdSide;
    protected double fourthSide;

    public Quadrilateral() {}

    public Quadrilateral(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        this.firstSide = firstPoint.distance(secondPoint);
        this.secondSide = secondPoint.distance(thirdPoint);
        this.thirdSide = thirdPoint.distance(fourthPoint);
        this.fourthSide = fourthPoint.distance(firstPoint);
    }

    @Override
    public final boolean equalsArea(IShape shape) {
        return squareOfShape() == shape.squareOfShape();
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

    public double getFourthSide() {
        return fourthSide;
    }

    public void setFourthSide(double fourthSide) {
        this.fourthSide = fourthSide;
    }
}

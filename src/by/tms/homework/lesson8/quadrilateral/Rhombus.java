package by.tms.homework.lesson8.quadrilateral;

import by.tms.homework.lesson6.Point;

import java.util.Objects;

public final class Rhombus extends Square {

    private int angleDegrees;

    public Rhombus(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, int angleDegrees) {
        super(firstPoint, secondPoint, thirdPoint, fourthPoint);
        this.angleDegrees = angleDegrees;
    }

    @Override
    public double squareOfShape() {
        return Math.pow(firstSide, 2) * Math.sin(angleDegrees);
    }

    @Override
    public double calcQuadrilateralDiagonal() {
        if (angleDegrees < 90) {
            return firstSide * Math.sqrt(2 - 2 * Math.cos(angleDegrees));
        } else {
            return firstSide * Math.sqrt(2 + 2 * Math.cos(angleDegrees));
        }
    }

    public double calcBiggerQuadrilateralDiagonal() {
        if (angleDegrees < 90) {
            return firstSide * Math.sqrt(2 + 2 * Math.cos(angleDegrees));
        } else {
            return firstSide * Math.sqrt(2 - 2 * Math.cos(angleDegrees));
        }
    }

    @Override
    public String toString() {
        return "Rhombus{" +
                "angleDegrees=" + angleDegrees +
                ", firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", thirdSide=" + thirdSide +
                ", fourthSide=" + fourthSide +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rhombus rhombus = (Rhombus) o;
        return angleDegrees == rhombus.angleDegrees;
    }

    @Override
    public int hashCode() {
        return Objects.hash(angleDegrees);
    }

    public int getAngleDegrees() {
        return angleDegrees;
    }

    public void setAngleDegrees(int angleDegrees) {
        this.angleDegrees = angleDegrees;
    }
}

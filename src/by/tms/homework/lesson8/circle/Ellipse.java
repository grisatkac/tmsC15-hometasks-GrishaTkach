package by.tms.homework.lesson8.circle;

import by.tms.homework.lesson6.Point;

import java.util.Objects;

public final class Ellipse extends Cycle {

    private double biggerRadius;

    public Ellipse(Point center, double radius, double biggerRadius) {
        super(center, radius);
        this.biggerRadius = biggerRadius;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "biggerRadius=" + biggerRadius +
                ", center=" + center +
                ", radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return Double.compare(ellipse.biggerRadius, biggerRadius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(biggerRadius);
    }

    @Override
    public double squareOfShape() {
        return Math.PI * radius * biggerRadius;
    }

    @Override
    public double calcLengthOfRound() {
        return 4 * (Math.PI * radius * biggerRadius + Math.pow(radius + biggerRadius, 2))
                / (radius + biggerRadius);
    }

    public double getBiggerRadius() {
        return biggerRadius;
    }

    public void setBiggerRadius(double biggerRadius) {
        this.biggerRadius = biggerRadius;
    }
}

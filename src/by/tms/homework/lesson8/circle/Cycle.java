package by.tms.homework.lesson8.circle;

import by.tms.homework.lesson6.Point;
import by.tms.homework.lesson8.IShape;

public abstract class Cycle implements ICircle {
    protected Point center;
    protected double radius;

    public Cycle() {}

    public Cycle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public final boolean equalsArea(IShape shape) {
        return squareOfShape() == shape.squareOfShape();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

package by.tms.homework.lesson8.utils;

import by.tms.homework.lesson8.IShape;
import by.tms.homework.lesson8.quadrilateral.Quadrilateral;
import by.tms.homework.lesson8.triangle.Triangle;

public final class ShapeUtils {

    private ShapeUtils() {}

    public static boolean isQuadrilateral(IShape shape) {
        return shape instanceof Quadrilateral;
    }

    public static boolean isTriangle(IShape shape) {
        return shape instanceof Triangle;
    }
}

package by.tms.homework.lesson8;

import by.tms.homework.lesson6.Point;
import by.tms.homework.lesson8.triangle.IsoscelesTriangle;
import by.tms.homework.lesson8.triangle.RectangularTriangle;
import by.tms.homework.lesson8.triangle.Triangle;
import by.tms.homework.lesson8.utils.ShapeUtils;

public class TestClass {
    public static void main(String[] args) {
        Point point1 = new Point(2, 5);
        Point point2 = new Point(2, 2);
        Point point3 = new Point(6, 2);


        RectangularTriangle recTriangle = new RectangularTriangle(point1, point2, point3);
        System.out.println(recTriangle.calcHeightTriangle());
        System.out.println(recTriangle.squareOfShape());

        Point point11 = new Point(0, 3);
        Point point22 = new Point(0, 0);
        Point point33 = new Point(4, 0);

        System.out.println(point11.distance(point22));
        System.out.println(point22.distance(point33));
        Triangle recTriangle1 = new RectangularTriangle(point11, point22, point33);

        System.out.println(recTriangle1.squareOfShape());
        System.out.println(recTriangle1.equalsArea(recTriangle));

        IsoscelesTriangle triangle = new IsoscelesTriangle(point1, point2, point3);
        IsoscelesTriangle triangle1 = new IsoscelesTriangle(point1, point2, point3);
        System.out.println(triangle1.equals(triangle1));
        System.out.println(triangle.calcHeightTriangle());
        System.out.println(triangle.squareOfShape());
        System.out.println(ShapeUtils.isQuadrilateral(triangle));
        System.out.println(ShapeUtils.isTriangle(triangle));
    }
}

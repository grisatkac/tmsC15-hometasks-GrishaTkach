package by.tms.homework.lesson6;

public class Main {

    public static void main(String[] args) {
        Point point1 = new Point(4, 4);
        Point point2 = new Point(8, 0);

        System.out.println(point1.distance(point2));

        Rectangle rectangle = new Rectangle(point1, point2);

        rectangle.getPoints();
        System.out.println("Area: " + rectangle.calcArea());
        System.out.println("Perimeter: " + rectangle.calcPerimeter());
        System.out.println("Diagonal: " + rectangle.calcDiagonal()+ "\n");

        Rectangle rectangle2 = new Rectangle();

        rectangle2.getPoints();

        Point point3 = new Point(-6 , 3);
        Point point4 = new Point(5, -2);

        rectangle2.setPoints(point3, point4);

        rectangle2.getPoints();
        System.out.println("Area: " + rectangle2.calcArea());
        System.out.println("Perimeter: " + rectangle2.calcPerimeter());
        System.out.println("Diagonal: " + rectangle2.calcDiagonal()+ "\n");

        Point point5 = new Point(-2, 2);
        Rectangle rectangle3 = new Rectangle(point5);

        rectangle3.getPoints();
        System.out.println("Area: " + rectangle3.calcArea());
        System.out.println("Perimeter: " + rectangle3.calcPerimeter());
        System.out.println("Diagonal: " + rectangle3.calcDiagonal());
    }
}

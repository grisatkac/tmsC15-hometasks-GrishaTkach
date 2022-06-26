package by.tms.homework.lesson6;

public class Rectangle {

    private Point point1;
    private Point point2;

    public Rectangle() {
        this(new Point());
    }

    public Rectangle(Point point) {
        this(point, new Point());
    }

    public Rectangle(Point point1, Point point2) {
        checkPoints(point1, point2);
    }

    public double calcArea() {
        return Math.abs((point2.getX() - point1.getX())
               * (point2.getY() - point1.getY()));
    }

    public double calcPerimeter() {
        return (Math.abs(point2.getX() - point1.getX())
                + Math.abs(point2.getY() - point1.getY())) * 2;
    }

    public double calcDiagonal() {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2)
               + Math.pow(point2.getY() - point1.getY(), 2));
    }

    public void getPoints() {
        System.out.println(point1.getX() + " " + point1.getY());
        System.out.println(point2.getX() + " " + point2.getY());
    }

    public void setPoints(Point point1, Point point2) {
        checkPoints(point1, point2);
    }

    private void checkPoints(Point point1, Point point2) {
        if (point1.getX() < point2.getX() && point1.getY() > point2.getY()) {
            this.point1 = point1;
            this.point2 = point2;
        } else {
            System.out.println("x of the first point must be less then x of the second point " +
                    "and y of the first point must be more then y of the second point");
            System.out.println("points got default values [0;0]");
            this.point1 = new Point(0, 0);
            this.point2 = new Point(0 , 0);
        }
    }
}

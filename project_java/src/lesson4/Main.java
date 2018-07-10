package lesson4;

import playground.geometry.Circle;
import playground.geometry.GeometricObject;
import playground.geometry.Rectangle;

public class Main {

    public static void main(String[] args) {

        Circle c1 = new Circle(10);
        Rectangle r1 = new Rectangle(10, 10);
        compare(c1, r1);

        GeometricObject c = new Circle(10);
//        MyComparable comparableCircle = new Circle(10);

        Circle cc = new Circle(10);

    }

    public static int compare(GeometricObject g1, GeometricObject g2) {
        if (g1.getArea() > g2.getArea()) {
            return 1;
        } else if (g1.getArea() < g2.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

}

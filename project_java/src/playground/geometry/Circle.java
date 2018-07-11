package playground.geometry;

import lesson5.comparing.MyComparable;

public class Circle extends GeometricObject implements MyComparable<Circle> {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Circle o) {
        return (int) (getArea() - o.getArea());
    }
}

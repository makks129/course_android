package lesson5.comparing;

import playground.geometry.Circle;

public class CircleComparator implements MyComparator {

    @Override
    public int compare(Object o1, Object o2) {
        double area1 = ((Circle) o1).getArea();
        double area2 = ((Circle) o2).getArea();
        return (int) (area1 - area2);
    }
}

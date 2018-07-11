package lesson5.comparing;

import playground.geometry.Circle;
import playground.geometry.GeometricObject;
import playground.geometry.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

//        Circle c1 = new Circle(10);
//        Circle c2 = new Circle(20);
//        int result = new CircleComparator().print(c1, c2);
//        int result2 = c1.compareTo(c2);


        MyComparator<Circle> circleComparator = new MyComparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                double a1 = o1.getArea();
                double a2 = o2.getArea();
                return (int) (a1 - a2);
            }
        };


        circleComparator.compare(new Circle(10), new Circle(20));
//        circleComparator.print(new Rectangle(10, 10), new Rectangle(20, 20));



        Integer[] ints = {1, 2, 3};

        String[] strings = {"a", "b", "c"};


    }

    
    public static <T> void print(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    

}

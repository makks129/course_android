package lesson5;

import playground.geometry.Circle;

import java.util.*;

/**
 * Java Collections Framework (JCF) hierarchy scheme can be found here:
 * <a href='https://www.isr.umd.edu/~austin/ence688r.d/java-collections.html'/>
 */
public class JcfTest {

    public static void main(String[] args) {


        List<String> arrayList = new ArrayList<>();
        arrayList.add("text");
        arrayList.add(10, "text");
        boolean contains = arrayList.contains("text");

        arrayList.remove(10);
        arrayList.remove("text");

        for (int i = 0; i < arrayList.size(); i++) {
            String s = arrayList.get(i);
        }


        Map<String, Circle> map = new HashMap<>();
        map.put("circle1", new Circle(10));
        map.put("circle2", new Circle(20));

        map.remove("circle2");

        Circle circle1 = map.get("circle1");

        boolean containsKey = map.containsKey("circle1");
        boolean containsValue = map.containsValue(circle1);

        Iterator<String> iterator = map.keySet().iterator();
        for (int i = 0; i < map.keySet().size(); i++) {
            String next = iterator.next();
            Circle circle = map.get(next);
        }


        Set<String> set = new HashSet<>();
        set.add("text");
        set.add("text");
        set.add("text");
        set.remove("text");
        Iterator<String> iterator1 = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            String value = iterator1.next();
        }




    }




}

package lesson2;

public class Main {

    public static class Student {

        int age;             // default: 0
        boolean isStudying;  // default: false
        char gender;         // default: '\u0000'
        String name;         // default: null

    }


    public static void main(String[] args) {

        Student student = new Student();
        System.out.println(student.age);
        System.out.println(student.isStudying);
        System.out.println(student.gender);
        System.out.println(student.name);

    }



}




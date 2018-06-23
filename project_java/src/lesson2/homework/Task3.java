package lesson2.homework;

public class Task3 {

    public static void main(String[] args) {

        TV samsungTv = new TV("Samsung");
        TV panasonicTv = new TV("Panasonic");
        TV hitachiTv = new TV("Hitachi");

        panasonicTv = hitachiTv;
        hitachiTv = samsungTv;
        samsungTv = panasonicTv;

        // Before running the program visualise object references and try to guess
        // which reference points to which object

        System.out.println(samsungTv.brand);
        System.out.println(panasonicTv.brand);
        System.out.println(hitachiTv.brand);


    }



}

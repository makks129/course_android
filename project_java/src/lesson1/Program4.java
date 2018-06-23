package lesson1;

public class Program4 {

    public static void main(String[] args) {

        int randomNumber = (int) (Math.random() * 100);


        if (randomNumber < 50) {
            System.out.println("Number " + randomNumber + " is less than 50");
        }
        if (randomNumber <= 50) {
            System.out.println("Number " + randomNumber + " is less than or equal to 50");
        }
        if (randomNumber > 50) {
            System.out.println("Number " + randomNumber + " is greater than 50");
        }
        if (randomNumber >= 50) {
            System.out.println("Number " + randomNumber + " is greater than or equal to 50");
        }
        if (randomNumber == 50) {
            System.out.println("Number " + randomNumber + " is equal to 50");
        }
        if (randomNumber != 50) {
            System.out.println("Number " + randomNumber + " is not equal to 50");
        }

    }

}



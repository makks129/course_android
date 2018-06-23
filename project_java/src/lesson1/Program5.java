package lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class Program5 {

    public static void main(String[] args) {

        // Initialise array and Scanner
        final int NUMBERS_AMOUNT = 3;
        double[] numbers = new double[NUMBERS_AMOUNT];
        Scanner scanner = new Scanner(System.in);

        // Enter numbers
        System.out.println("Enter " + NUMBERS_AMOUNT + " of numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            double number = scanner.nextDouble();
            // Store new number in array
            numbers[i] = number;
        }
        System.out.println("Numbers are: " + Arrays.toString(numbers));

        // Sum numbers
        double sumOfNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumOfNumbers += numbers[i];
        }
        // Compute average
        double average = sumOfNumbers / numbers.length;
        System.out.println("Average is: " + average);

    }

}



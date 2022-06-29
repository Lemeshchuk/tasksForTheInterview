package thirdTask;

/**
 * This class is the entry to the program and is used to start the program.
 * When you start the application, the program starts to calculate the factorial
 * and after that the sum of its numbers, the results will be printed to the console.
 *
 * @author  Artem Lemeshchuk
 * @version 1.0
 * @since 25.06.2022
 */

public class Main {

    public static void main(String[] args) {

        FindingTheSumOfTheFactorialDigits findingTheSumOfTheFactorialDigits = new FindingTheSumOfTheFactorialDigits();
        int digit = 100;
        System.out.println("Sum of numbers in factorial " + digit + " = "
                + findingTheSumOfTheFactorialDigits.getSumOfDigits(digit));
    }
}

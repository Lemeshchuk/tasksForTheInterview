package thirdTask;

import java.math.BigInteger;

/**
 * There are two methods in this class that process any of the given numbers and return
 * the result. More details about the work of the methods are described in the methods themselves.
 *
 * @author  Artem Lemeshchuk
 * @see java.math.BigInteger;
 * @version 1.0
 * @since 25.06.2022
 */

public class FindingTheSumOfTheFactorialDigits {

    BigInteger factorial = BigInteger.ONE;

    /**
     * This method gets the sum of all numbers of the factorial value,
     * I use BigInteger, because the number is very large and cannot fit into an Integer.
     *
     * @param digit - The number specified in the Main class to be processed
     * @return The sum of factorial numbers
     */

    public long getSumOfDigits(int digit) {
        int sum = 0;
        factorial = findingTheFactorial(digit);

        while (factorial.compareTo(BigInteger.ZERO) > 0) {
            sum += factorial.mod(BigInteger.TEN).longValue();
            factorial = factorial.divide(BigInteger.TEN);
        }
        return sum;
    }

    /**
     * This method gets the factorial of the given number by multiplying all the numbers of the number, in turn.
     *
     * @param digit - The number specified in the Main class to be processed
     * @return Factorial of a given number
     */
    public BigInteger findingTheFactorial(int digit) {

        for (int i = 1; i <= digit; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}

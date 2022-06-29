package firstTask;

import java.util.Scanner;

/**
 * This Class works as a number reader from the keyboard, you can see
 * a detailed description in the method description.
 *
 * @author  Artem Lemeshchuk
 * @see java.util.Scanner;
 * @version 1.0
 * @since 25.06.2022
 */

public class ScannerFromKeyboard {

    int enteredNumber;

    /**
     * This method asks to enter a number on the keyboard, then checks whether it is positive and has no decimal
     * endings, if it has, then an exception is thrown, if not, the method returns a number.
     *
     * @return Integer and positive number entered from the keyboard
     */
    public int readNumberFromKeyboard() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");

        while (true) {
            try {
                enteredNumber = Integer.parseInt(scanner.nextLine());
                if (enteredNumber < 0) throw new IllegalArgumentException();
                break;
            } catch (NumberFormatException ex) {
                System.out.print("Entered symbols isn't integer number, please enter number again: ");
            } catch (IllegalArgumentException ex) {
                System.out.print("Number must be a positive, please enter number again: ");
            }
        }
        return enteredNumber;
    }
}

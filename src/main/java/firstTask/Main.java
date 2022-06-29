package firstTask;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the entry to the program and is used to start the program.
 * After starting the program, enter any integer, and in response you will
 * receive a bracket expression.
 *
 * @author  Artem Lemeshchuk
 * @see java.util.List;
 * @see java.util.ArrayList;
 * @version 1.0
 * @since 25.06.2022
 */

public class Main {

    public static void main(String[] args) {

        ScannerFromKeyboard scanner = new ScannerFromKeyboard();
        BracesGenerator bracesGenerator = new BracesGenerator();

        List<String> listOfBracketExpressions = new ArrayList<>(bracesGenerator.generatePairs(scanner.readNumberFromKeyboard()));

        System.out.println("Bracket expression: " + listOfBracketExpressions + System.lineSeparator() +
                "Number of bracers options: " + listOfBracketExpressions.size());
    }
}

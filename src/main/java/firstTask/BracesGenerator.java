package firstTask;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class receives a number, how many bracket expressions it generates
 * and starts generating expressions, as well as adding pairs of brackets to
 * correctly display the bracket expression.
 *
 * @author  Artem Lemeshchuk
 * @see java.util.List;
 * @see java.util.ArrayList;
 * @version 1.0
 * @since 25.06.2022
 */

public class BracesGenerator {

    char[] arrayOfBrackets;
    List<String> listOfBracketExpressions = new ArrayList<>();

    /**
     * The method takes the entered number, creates an array of chars the size
     * of the entered number multiplies by two, and calls the method "addPairs"
     *
     * @param enteredNumber - number entered from the keyboard and given to search for a bracket expression
     * @return List Of Bracket Expressions
     */
    public List<String> generatePairs(int enteredNumber) {
        arrayOfBrackets = new char[enteredNumber * 2];
        addPairs(listOfBracketExpressions, enteredNumber, enteredNumber, 0);

        return listOfBracketExpressions;
    }

    /**
     *  This method recursively checks for correctness of the bracket expression,
     *  and fills the bracket expression List, in the correct order.
     *
     * @param listOfBracketExpressions - List Of Bracket Expressions
     * @param leftBracket - Used to construct a correct bracket expression
     * @param rightBracket  - Used to construct a correct bracket expression
     * @param count - Used to count the number of added brackets
     */
    public void addPairs(List<String> listOfBracketExpressions, int leftBracket, int rightBracket, int count) {

        if (leftBracket < 0 || rightBracket < leftBracket) return;

        if (leftBracket == 0 && rightBracket == 0) {
            listOfBracketExpressions.add(String.copyValueOf(arrayOfBrackets));
        } else {
            if (leftBracket > 0) {
                arrayOfBrackets[count] = '(';
                addPairs(listOfBracketExpressions, leftBracket - 1, rightBracket, count + 1);
            }
            if (rightBracket > leftBracket) {
                arrayOfBrackets[count] = ')';
                addPairs(listOfBracketExpressions, leftBracket, rightBracket - 1, count + 1);
            }
        }
    }
}

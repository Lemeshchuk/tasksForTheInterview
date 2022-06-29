package secondTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is the entry to the program and is used to start the program.
 * When the application is launched, the program starts automatically reading the file,
 * then the necessary methods are generated to process the cheapest option for traveling from
 * city to city, and the results are output to the console.
 *
 * @author  Artem Lemeshchuk
 * @see java.io.IOException;
 * @see java.io.FileReader;
 * @see java.io.BufferedReader;
 * @version 1.0
 * @since 25.06.2022
 */

public class Main {

    public static void main(String[] args) {

        Tests tests = new Tests();
        String pathToFile = "src/main/java/secondTask/Input.txt";
        int numberOfTests;

        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String curLineOfFile = reader.readLine();
            numberOfTests = Integer.parseInt(curLineOfFile);
            tests.doAllTests(reader, numberOfTests);
        } catch (IOException e) {
            System.out.println("Oops, something went wrong(((");
        }
    }
}

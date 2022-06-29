package secondTask;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * This Class launches the rest of the classes, executing the task in a chain. the method is described below
 *
 * @author  Artem Lemeshchuk
 * @see java.io.BufferedReader;
 * @see java.io.IOException;
 * @version 1.0
 * @since 25.06.2022
 */

public class Tests {

    FindDestinationDistance findDestinationDistance = new FindDestinationDistance();
    Matrix matrix;
    String[] citiesIds = new String[10000];
    int numberOfCities;
    int matrixSize;
    int routesToFind;
    int resolvingProblemWithIndexingTheArrayFromNull = 1;

    /**
     * The method replaces the work of Tests, simulating them and executes
     * the full cycle of the program, the number of tests is read from the file.
     *
     * @param reader - stream reading file line by line
     * @param testIndexInSource - the beginning of the path
     * @throws IOException - handled in main class
     */

    public void doAllTests(BufferedReader reader, int testIndexInSource) throws IOException {

        for (int testIndex = 0; testIndex < testIndexInSource; testIndex++) {
            numberOfCities = Integer.parseInt(reader.readLine());
            matrixSize = numberOfCities + resolvingProblemWithIndexingTheArrayFromNull;
            matrix = new Matrix(matrixSize);
            matrix.setMatrixEdges(reader, citiesIds, numberOfCities, matrix);
            routesToFind = Integer.parseInt(reader.readLine());
            findDestinationDistance.findDistance(reader, citiesIds, matrix, routesToFind);
        }
    }
}

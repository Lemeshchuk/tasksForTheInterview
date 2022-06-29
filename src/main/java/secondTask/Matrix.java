package secondTask;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * This class creates a matrix to easily find the cost of traveling between cities, each method is described below.
 *
 * @author  Artem Lemeshchuk
 * @see java.io.BufferedReader;
 * @see java.io.IOException;
 * @version 1.0
 * @since 25.06.2022
 */

public class Matrix {

    public final int[][] cost;
    String[] brokenLine;
    String cityName;
    int numberOfNeighbours;
    int cityToConnect;
    int weightOfConnection;

    Matrix(int vertices) {
        cost = new int[vertices][vertices];
    }

    /**
     * The method builds a matrix grid and enters cities from the file into it, and also finds neighboring cities.
     *
     * @param reader - stream reading file line by line
     * @param citiesIds - assigning an ID to each city
     * @param numberOfCities - number of cities in the file
     * @param matrixSize - matrix size as constructor parameter
     * @throws IOException - handled in main class
     */
    public void setMatrixEdges(BufferedReader reader, String[] citiesIds, int numberOfCities, Matrix matrixSize) throws IOException {

        for (int cityIndex = 0; cityIndex < numberOfCities; cityIndex++) {
            cityName = reader.readLine();
            citiesIds[cityIndex] = cityName;
            numberOfNeighbours = Integer.parseInt(reader.readLine());

            for (int neighbourIndex = 0; neighbourIndex < numberOfNeighbours; neighbourIndex++) {
                brokenLine = reader.readLine().split(" ");
                cityToConnect = Integer.parseInt(brokenLine[0]);
                weightOfConnection = Integer.parseInt(brokenLine[1]);
                matrixSize.setEdge(cityIndex, cityToConnect, weightOfConnection);
            }
        }
    }

    /**
     * The method sets the matrix boundaries, vertical and horizontal
     *
     * @param vertical - vertical of matrix
     * @param horizontal - horizontal of matrix
     * @param weight - price of Connection
     */
    public void setEdge(int vertical, int horizontal, int weight) {
        cost[vertical][horizontal] = weight;
    }

    /**
     * The method gets the cost of the trip from the given cities, using the matrix
     *
     * @param vertical - vertical of matrix
     * @param horizontal -  horizontal of matrix
     * @return - price of Connection
     *
     * A good example of what it looks like
     * /* [0, 0, 1, 3, 0]
     *  * [0, 1, 0, 1, 4]
     *  * [0, 3, 1, 0, 1]
     *  * [0, 0, 4, 1, 0]*/
    public int getCost(int vertical, int horizontal) {

        if (vertical == horizontal) {
            return 0;
        }
        if (cost[vertical][horizontal] == 0) {
            return 10001;
        }
        return cost[vertical][horizontal];
    }

    /**
     * The method finds the lowest cost of a trip by iterating through all possible options in a loop
     *
     * @param options - travel pricing options
     * @param visited - Visited cities
     * @return = best result
     */
    public int getCheapest(Integer[] options, boolean[] visited) {
        int bestResult = -1;
        for (int i = 0; i < cost.length; i++) {
            if (!visited[i] && ((bestResult < 0) || (options[i] < options[bestResult]))) {
                bestResult = i;
            }
        }
        return bestResult;
    }
}

package secondTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This Class finds distances to given cities based on parameters. This Class terminates the application.
 * More details about the methods and operation of this class are described below for methods.
 *
 * @author  Artem Lemeshchuk
 * @see java.util.List;
 * @see java.util.ArrayList;
 * @see java.util.Arrays
 * @see java.io.IOException
 * @see java.io.BufferedReader
 * @version 1.0
 * @since 25.06.2022
 */

public class FindDestinationDistance {

    CityFinder cityFinder = new CityFinder();
    List<String> listOfCitiesIds = new ArrayList<>();
    Integer[] distancesFromSource;
    Integer[] result;
    String[] cityNames;
    String start;
    String destination;
    int startIndex;
    int destinationIndex;
    int destinationDistance;
    int cityToCheckTheCost;
    int setTopsMark = 10001;

    /**
     * In this method, the cheapest option from city to city is found,
     * and displayed on the console as a logical conclusion to the entire program.
     *
     * @param reader - stream reading file line by line
     * @param citiesIds - assigning an ID to each city
     * @param matrixSize - matrix size as constructor parameter
     * @param routesToFind - routes for which you want to search
     * @throws IOException - handled in main class
     */

    public void findDistance(BufferedReader reader, String[] citiesIds, Matrix matrixSize, int routesToFind) throws IOException {

        for (int routesIndex = 0; routesIndex < routesToFind; routesIndex++) {
            cityNames = reader.readLine().split(" ");
            start = cityNames[0];
            destination = cityNames[1];
            cityFinder.fillListOfCitiesIds(citiesIds, listOfCitiesIds);
            citiesIds = listOfCitiesIds.toArray(new String[0]);
            startIndex = cityFinder.findIndexOfCity(citiesIds, start);
            destinationIndex = cityFinder.findIndexOfCity(citiesIds, destination);
            distancesFromSource = getDistancesFromSource(startIndex, matrixSize);
            destinationDistance = distancesFromSource[destinationIndex];
            System.out.println(destinationDistance);
        }
    }

    /**
     * This method finds the distance from the beginning of the path to the city,
     * I use a boolean variable to designate cities that have already been visited
     * in the loop, and then pass it as a parameter to the method "getCheapest"
     * thus, paired with this method, I find the values I need in the second cycle of this method.
     *
     * @param source - the beginning of the path
     * @param matrix - an object of the matrix class
     * @return - an array of the distances from source to each other vertex
     */
    public Integer[] getDistancesFromSource(int source, Matrix matrix) {
        result = new Integer[matrix.cost.length];
        Arrays.fill(result, setTopsMark);
        result[source] = source;
        boolean[] visited = new boolean[matrix.cost.length];

        for (int i = 0; i < matrix.cost.length; i++) {
            cityToCheckTheCost = matrix.getCheapest(result, visited);
            visited[cityToCheckTheCost] = true;
            for (int j = 0; j < matrix.cost.length; j++) {
                result[j] = Math.min(result[j], result[cityToCheckTheCost] + matrix.getCost(cityToCheckTheCost, j));
            }
        }
        return result;
    }
}

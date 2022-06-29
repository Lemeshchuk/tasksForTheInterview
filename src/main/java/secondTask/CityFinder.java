package secondTask;

import java.util.List;

/**
 * This Class has two methods for working with cities, each method is described separately.
 *
 * @author  Artem Lemeshchuk
 * @see java.util.List;
 * @version 1.0
 * @since 25.06.2022
 */

public class CityFinder {

    /**
     * The method searches for the required city by index using a loop.
     *
     * @param citiesIds - assigning an ID to each city
     * @param destination - the direction we need
     * @return - required city index
     */
    public int findIndexOfCity(String[] citiesIds, String destination) {
        int resultIndex = 0;
        for (int i = 0; i < citiesIds.length; i++) {
            if (destination.equals(citiesIds[i])) {
                resultIndex = i;
                break;
            }
        }
        return resultIndex;
    }

    /**
     * The method fills the List using the data from the array
     *
     * @param citiesIds - assigning an ID to each city
     * @param listOfCitiesIds - filling the list with cities
     */
    public void fillListOfCitiesIds(String[] citiesIds, List<String> listOfCitiesIds) {
        for (String s : citiesIds) {
            if (s != null) {
                listOfCitiesIds.add(s);
            }
        }
    }
}

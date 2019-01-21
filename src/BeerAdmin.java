import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

class BeerAdmin {
    private HashMap<Integer, String> beerStyles = new HashMap<>();
    private HashMap<String, Data> beerListForStyle = new HashMap<>();

    /**
     * Loads all beers and parses them to a Beer instance.
     * Iterates through beer instance with foreach and puts everytime the record to HashMap beerStyles.
     */
    void loadBeerStyles() {
        try {
            beerStyles.clear();
            URL url = new URL("http://api.brewerydb.com/v2/styles/?key=1511d0db4a1d6841481c672455358cff");
            InputStreamReader reader = new InputStreamReader(url.openStream());
            Beer beer = new Gson().fromJson(reader, Beer.class);
            for (Data d : beer.getData()) {
                beerStyles.put(Integer.valueOf(d.getId()), d.getName());
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Iterates through beerStyles HashMap with foreach.
     * Stores current value in String.
     * Prints key and value to console
     */
    void printBeerStyles() {
        for (int key : beerStyles.keySet()) {
            String value = beerStyles.get(key);
            System.out.println(key + "::" + value);
        }
    }

    /**
     * Iterates through beerStyles HashMap with foreach.
     * Stores current value in String.
     * Checks whether the value contains the given String search.
     * Prints key and value to console when the condition is true
     *
     * @param search A String which will be used to search in the values of HashMap beerStyles.
     */
    void printBeerStyles(String search) {
        boolean found = false;
        for (int key : beerStyles.keySet()) {
            String value = beerStyles.get(key);
            if (value.contains(search)) {
                System.out.println(key + "::" + value);
                found = true;
            }
        }
        if (!found)
            System.out.println("No beer found.");
    }

    /**
     * Clears the previous entries in beerListForStyle.
     * Gets the Data from webservice.
     * Parses data and stores them in a Beer instance.
     * Iterates through HashMap beerListForStyle to put key and value to the HashMap.
     * Iterates again, this time to find a record matching the given idStyle.
     * If there is a match it prints key and value.
     *
     * @param idStyle An ID which will be used to search in the keys of HashMap beerListForStyle
     */
    void getBeerListForStyle(int idStyle) {
        try {
            beerListForStyle.clear();
            URL url = new URL("http://api.brewerydb.com/v2/beers/?key=1511d0db4a1d6841481c672455358cff&styleId=" + idStyle);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            Beer beer = new Gson().fromJson(reader, Beer.class);
            for (Data d : beer.getData()) {
                beerListForStyle.put(d.getId(), d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean found = false;
        for (String key : beerListForStyle.keySet()) {
            Data value = beerListForStyle.get(key);
            if (value.getStyleId() == idStyle) {
                found = true;
                System.out.println(key + "::" + value);
            }
        }
        if (!found)
            System.out.println("No beer found.");
    }

    /**
     * Iterates through HashMap beerListForStyle.
     * Gets the value from key.
     * Prints both to the console.
     */
    void printBeerList() {
        for (String key : beerListForStyle.keySet()) {
            Data value = beerListForStyle.get(key);
            System.out.println(key);
            System.out.println(value.toString());
        }
    }

    /**
     * Iterates through HashMap beerListForStyle.
     * Checks whether the id is the one it is searched for.
     * If condition is true it prints the key and value to console.
     *
     * @param id An ID which will be used to search in the keys of HashMap beerListForStyle
     */
    void printBeer(String id) {
        boolean found = false;
        for (String key : beerListForStyle.keySet()) {
            Data value = beerListForStyle.get(key);
            if (key.equals(id)) {
                System.out.println(key + "::" + value.getName());
                System.out.println(value.getDescription());
                found = true;
            }
        }
        if (!found)
            System.out.println("No beer found.");
    }

    /**
     * A method to ask the user about something and get the user input.
     *
     * @param output A String which will be printed to the console to let the user know what he has to write.
     * @return String
     */
    static String getInput(String output) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(output);
        return scanner.nextLine();
    }
}

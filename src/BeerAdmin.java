import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class BeerAdmin {
    private HashMap<String, String> beerStyles = new HashMap<>();
    private HashMap<String, Data> beerListForStyle = new HashMap<>();

    void loadBeerStyles() {
        try {
            beerStyles.clear();
            URL url = new URL("http://api.brewerydb.com/v2/styles/?key=1511d0db4a1d6841481c672455358cff");
            InputStreamReader reader = new InputStreamReader(url.openStream());
            Beer beer = new Gson().fromJson(reader, Beer.class);
            for (Data d : beer.getData()) {
                beerStyles.put(d.getId(), d.getName());
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    void printBeerStyles() {
        for (String key : beerStyles.keySet()) {
            String value = beerStyles.get(key);
            System.out.println(key + "::" + value);
        }
    }

    void printBeerStyles(String search) {
        boolean found = false;
        for (String key : beerStyles.keySet()) {
            String value = beerStyles.get(key);
            if (value.contains(search)) {
                System.out.println(key + "::" + value);
                found = true;
            }
        }
        if (!found)
            System.out.println("No beer found.");
    }

    public void getBeerListForStyle(int idStyle) {
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
        for (String key : beerStyles.keySet()) {
            String value = beerStyles.get(key);
            if (key.contains(String.valueOf(idStyle))) {
                found = true;
                System.out.println(key + "::" + value);
                break;
            }
        }
        if (!found)
            System.out.println("No beer found.");
    }

    void printBeerList() {
        for (String key : beerListForStyle.keySet()) {
            Data value = beerListForStyle.get(key);
            System.out.println(key);
            System.out.println(value.toString());
        }
    }

    void printBeer(String id) {
        boolean found = false;
        for (String key : beerListForStyle.keySet()) {
            Data value = beerListForStyle.get(key);
            if (key.equals(id)) {
                System.out.println("ID: " + key + ", Name: " + value.getName());
                System.out.println(value.getDescription());
                found = true;
            }
        }
        if (!found)
            System.out.println("No beer found.");
    }

    static String getInput(String output) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(output);
        return scanner.nextLine();
    }
}

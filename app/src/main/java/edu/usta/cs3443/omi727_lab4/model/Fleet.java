package edu.usta.cs3443.omi727_lab4.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Fleet.java
 * <p>
 * This class will represent a Fleet object, which we will define as having:
 * <p>
 * A name, represented as a String (e.g. “United Federation of Planets”) An
 * ArrayList of Starship objects A constructor which requires all String fields
 * and initializes the collection A getSizeOfFleet() method which returns the
 * number of starships in the fleet An addStarship(..) method which takes a
 * Starship parameter and adds it to the fleet, returning nothing. A toString()
 * method which calls upon the toString() in Starship to return a string
 * representation of the fleet. Getters and setters for all fields A
 * loadStarships(…) method which takes in a directory name and adds a Starship
 * to the Fleet for each file found. This method should not return anything and
 * needs to “throw” an exception in order to allow for file I/O.
 *
 * @author Alistair Chambers (omi727)
 * UTSA CS 3443 - Lab 4
 */

public class Fleet {

    private String name;
    private ArrayList<Starship> starships;

    /**
     * @param name
     */
    public Fleet(String name) {
        this.name = name;
        this.starships = new ArrayList<>();

    }

    /**
     * @return
     */
    public int getSizeOfFleet() {
        return starships.size();
    }

    /**
     * @param starship
     */
    public void addStarship(Starship starship) {
        starships.add(starship);
    }

    /**
     *
     */
    @Override
    public String toString() {


        String result = "----------------------------\n\n";
        result += name + "\n\n";
        result += "----------------------------\n\n";

        for (Starship starship : starships) {
            result += starship.toString() + "\n\n";
        }

        return result;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public ArrayList<Starship> getStarships() {
        return starships;
    }

    /**
     * @param starships
     */
    public void setStarships(ArrayList<Starship> starships) {
        this.starships = starships;
    }

    /**
     *
     * @param personnel
     * @param fleet
     * @param context
     * @throws IOException
     */
    public void loadStarships(String personnel,String fleet, Context context) throws IOException {
        List<String> lines = loadAllLinesFromAssets(context, personnel);
        List<String> lines1 = loadAllLinesFromAssets(context, fleet);

        Log.d("DEBUG", "Loaded " + lines.size() + " lines from " + personnel);
        HashMap<String, Starship> starshipMap = getStringStarshipHashMap(lines1);
        //loads crew from lines into hashmap
        for (String line : lines) {
            String[] columns = line.split(",");
            String name = columns[0];
            String position = columns[1];
            String title = columns[2];
            String registry = columns[3];
            String species = columns[4];
            CrewMember crewMember = new CrewMember(name, position, title, species);
            try {
                if (starshipMap.containsKey(registry))  {
                    starshipMap.get(registry).addCrewMember(crewMember);
                }
            } catch ( NullPointerException e) {
                throw new NullPointerException(e.getMessage());
            }
        }
        //add hashmap to starship
        for (Starship starship : starshipMap.values()) {
            addStarship(starship);
        }



    }

    /**
     *
     * @param lines1
     * @return
     */
    @NonNull
    private static HashMap<String, Starship> getStringStarshipHashMap(List<String> lines1) {
        HashMap<String, Starship> starshipMap = new HashMap<>();
        for (String line : lines1) {
            // Split the line into columns
            String[] columns = line.split(",");
            String starshipName = columns[0];
            String starshipRegistry = columns[1];
            String starshipClass = columns[2];
            // Create a Starship object and add it to the hashmap
            Starship starship = new Starship(starshipName, starshipRegistry, starshipClass);
            starshipMap.put(starshipRegistry, starship);
        }
        return starshipMap;
    }

    /**
     *
     * @param context
     * @param filename
     * @return
     * @throws IOException
     */
    private List<String> loadAllLinesFromAssets(Context context, String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        AssetManager assetManager = context.getAssets();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(assetManager.open(filename)))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + filename, e);
        }

        return lines;
    }

}

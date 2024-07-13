package edu.usta.cs3443.omi727_lab4.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Starship.java
 * <p>
 * This class will represent a Starship object, which we will define as having:
 * <p>
 * A name, represented as a String (e.g. “USS Enterprise”) A registry, (e.g.
 * “NCC-1701-A”) A class of starship (e.g. “Constitution”) An ArrayList of
 * CrewMember objects A constructor which requires all String fields and
 * initializes the collection A toString() method which returns a String
 * representation of the Starship An addCrewMember(…) method which takes a
 * CrewMember parameter and adds them to the starship and returns nothing A
 * getNumberOfPersonnel() method which takes no parameters and returns an
 * integer count of crew members on the starship Getters and setters for all
 * fields
 *
 * @author Alistair Chambers (omi727)
 * UTSA CS 3443 - Lab 4
 */
public class Starship implements Serializable {
    private String name;
    private String registry;
    private String starshipClass;
    private ArrayList<CrewMember> crewMembers;

    /**
     * @param name
     * @param registry
     * @param starshipClass
     */
    public Starship(String name, String registry, String starshipClass) {
        this.name = name;
        this.registry = registry;
        this.starshipClass = starshipClass;
        this.crewMembers = new ArrayList<>();
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();


        sb.append(name).append(", ").append(starshipClass).append(". Registry: ").append(getRegistry()).append("\n");

        if (crewMembers.isEmpty()) {
            //sb.append(getNumberOfPersonnel());
            sb.append("\n0 crew members assigned.\n");
        } else {
            sb.append("\n" + crewMembers.size()).append(" crew members assigned.\n\n");
            for (CrewMember crewMember : crewMembers) {
                sb.append(" - ").append(crewMember.toString()).append("\n");
            }
        }

        sb.append("\n");

        return sb.toString();
    }

    /**
     * @param crewMember
     */
    public void addCrewMember(CrewMember crewMember) {
        crewMembers.add(crewMember);
    }

    /**
     * @return
     */
    public int getNumberOfPersonnel() {
        return crewMembers.size();
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
     *
     * @return
     */
    public String getRegistry() {
        return registry;
    }

    /**
     *
     * @param registry
     */
    public void setRegistry(String registry) {
        this.registry = registry;
    }

    /**
     *
     * @return
     */
    public String getStarshipClass() {
        return starshipClass;
    }

    /**
     *
     * @param starshipClass
     */
    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    /**
     *
     * @return
     */
    public ArrayList<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    /**
     *
     * @param crewMembers
     */
    public void setCrewMembers(ArrayList<CrewMember> crewMembers) {
        this.crewMembers = crewMembers;
    }

}

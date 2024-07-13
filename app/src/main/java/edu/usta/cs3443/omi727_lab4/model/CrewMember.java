package edu.usta.cs3443.omi727_lab4.model;

/**
 * CrewMember.java
 * <p>
 * This class will represent a CrewMember object, which we will define as
 * having:
 * <p>
 * A name, represented as a String (e.g. “James T. Kirk”) A position, (e.g.
 * “Commanding Officer”) A rank, (e.g. “Captain”) A species (e.g. “Human”) An
 * assignment (e.g. “NCC-1701-A”) Two constructors - one which requires all of
 * the above fields, and one which requires all except for the assignment. A
 * toString() method which returns a String representation of the CrewMember
 * Getters and setters for all fields
 *
 * @author Alistair Chambers (omi727)
 * UTSA CS 3443 - Lab 4
 */

public class CrewMember {
    private String name;
    private String position;
    private String rank;
    private String Species;
    private String Assignment;

    /**
     * @param name
     * @param position
     * @param rank
     * @param species
     * @param assignment
     */
    public CrewMember(String name, String position, String rank, String species, String assignment) {
        this.name = name;
        this.position = position;
        this.rank = rank;
        this.Species = species;
        this.Assignment = assignment;
    }

    /**
     * @param name
     * @param position
     * @param rank
     * @param species
     */
    public CrewMember(String name, String position, String rank, String species) {
        this(name, position, rank, species, null);
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
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * @return
     */
    public String getSpecies() {
        return Species;
    }

    /**
     * @param species
     */
    public void setSpecies(String species) {
        Species = species;
    }

    /**
     * @return
     */
    public String getAssignment() {
        return Assignment;
    }

    /**
     * @param assignment
     */
    public void setAssignment(String assignment) {
        Assignment = assignment;
    }

    /**
     *
     * @return
     */
    @Override

    public String toString() {
        return getName() + " (" + getRank() + ") - " + getPosition() + " [" + getSpecies() + "]\n";
    }


}

package com.example.trainingapp.model.components;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class for creating an exercise. Several exercises makes up a workout
 */
public class Exercise {

    /**
     * Name of the exercise
     */
    private String exerciseName;

    /**
     * Number of sets for the exercise
     */
    private int numberOfSets;

    /**
     * Number of reps for the exercise
     */
    private int numberOfReps;

    /**
     *
     *
     */
    private final String exerciseId;

    /**
     * Class constructor setting exerciseName and exerciseId
     *
     * @param exerciseName name of exercise
     * @param exerciseId Id of exercise
     */
    public Exercise() {
        this.exerciseId = UUID.randomUUID().toString();
        this.exerciseName = "New exercise";
    }

    /**
     * Method to get the number of sets of the exercise
     */
    public int getNumberOfSets() {
        return numberOfSets;
    }

    /**
     * Method to set the number of set of the exercise
     *
     * @param numberOfSets
     */
    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    /**
     * Method to get the number of reps of the exercise
     */
    public int getNumberOfReps() {
        return numberOfReps;
    }

    /**
     * Method to change the number of reps of the exercise
     *
     * @param numberOfReps
     */
    public void setNumberOfReps(int numberOfReps) {
        this.numberOfReps = numberOfReps;
    }
    /**
     * Method for getting the name of the exercise
     *
     * @return The name of the exercise
     */
    public String getName(){
        return exerciseName;
    }

    /**
     * Method to change the number of reps of the exercise
     * @param name
     */
    public void setName(String name) {
        exerciseName = name;
    }
    /**
     * Method for getting the exerciseId of the exercise
     *
     * @return The exerciseId of the exercise
     */
    public String getId(){
        return exerciseId;
    }





}

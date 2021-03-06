package com.example.trainingapp.model.components;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class for creating an exercise. Several exercises makes up a workout
 *  @author Victor Hui, Valdemar Vålvik, Oscar Wallin
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
     * The Id for the exercise
     */
    private final String exerciseId;

    /**
     * Class constructor setting a specified exerciseName and generated exerciseId
     *
     * @param exerciseName name of exercise
     */
    public Exercise(String exerciseName, int reps, int sets) {
        this.exerciseName = exerciseName;
        this.exerciseId = UUID.randomUUID().toString();
        this.numberOfReps = reps;
        this.numberOfSets = sets;
    }

    /**
     * Class constructor setting default exerciseName and generated exerciseId
     *
     */
    protected Exercise(){
        this.exerciseName = "New Exercise";
        this.exerciseId = UUID.randomUUID().toString();
        this.numberOfReps = 0;
        this.numberOfSets = 0;
    }

    /**
     * Class constructor for defensive copy
     *
     * @param exercise what exercise-object to copy
     */
    protected Exercise(Exercise exercise) {
        this.exerciseName = exercise.getName();
        this.exerciseId = exercise.getId();
        this.numberOfReps = exercise.getNumberOfReps();
        this.numberOfSets = exercise.getNumberOfSets();
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
    protected void setNumberOfSets(int numberOfSets) {
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
    protected void setNumberOfReps(int numberOfReps) {
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
     * Method to change the name of the exercise
     * @param name
     */
    protected void setName(String name) {
        exerciseName = name;
    }

    /**
     * Method for getting the exerciseId of the exercise
     *
     * @return The exerciseId of the exercise
     */
    public String getId(){ return exerciseId; }
}

package com.example.trainingapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class for creating an activeExercise. Several exercises makes up a workout
 */
public class ActiveExercise {

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
     * An exercise contains an id to make it possible for PB-recording purposes. For example
     * all Bench Press exercises will have the same id.
     */
    private int exerciseId;

    /**
     * Amount of weight for the activeExercise
     */
    private int weight;

    /**
     * Class constructor setting exerciseName and exerciseId
     *
     * @param exerciseName name of exercise
     * @param exerciseId Id of exercise
     */
    public ActiveExercise(String exerciseName, int exerciseId, int numberOfReps, int numberOfSets) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.numberOfReps = numberOfReps;
        this.numberOfSets = numberOfSets;
        this.weight = 0;
    }

    /**
     * Method to get the number of sets of the exercise
     */
    public int getNumberOfSets() {
        return numberOfSets;
    }

    /**
     * Method to set the number of set of the exercise
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
     * @param numberOfReps
     */
    public void setNumberOfReps(int numberOfReps) {
        this.numberOfReps = numberOfReps;
    }
    /**
     * Method for getting the name of the exercise
     * @return The name of the exercise
     */
    public String getName(){
        return exerciseName;
    }

    /**
     * Method for getting the exerciseId of the exercise
     * @return The exerciseId of the exercise
     */
    public int getExerciseId(){
        return exerciseId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



}

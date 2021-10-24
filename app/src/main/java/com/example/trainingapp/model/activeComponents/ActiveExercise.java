package com.example.trainingapp.model.activeComponents;

import com.example.trainingapp.model.components.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class for creating an active exercise. The class is identical to the Exercise-class, but with added
 * variables and logic to handle a weight used at each set.
 *  @author Victor Hui, Valdemar Vålvik, Oscar Wallin
 */
public class ActiveExercise {

    /**
     * Name of the exercise
     */
    private String exerciseName;

    /**
     * List of reps. Ex 12 + 12 + 8 -> 3 sets with different amount of repetitions.
     */
    private int noOfReps;

    /**
     * This is a list of the weight used in each set. Default value is zero.
     */
    private double weight;

    /**
     * An exercise contains an id to make it possible for PB-recording purposes. For example
     * all Bench Press exercises will have the same id.
     */
    private final String exerciseId;

    /**
     * Class constructor. Responsible for converting an exercise to an active exercise.
     * @param exercise The exercise-object to be converted.
     */
    protected ActiveExercise(Exercise exercise){
        this.exerciseName = exercise.getName();
        this.exerciseId = UUID.randomUUID().toString();
        this.noOfReps = exercise.getNumberOfReps();
        this.weight = 0;
    }

    /**
     * Method for getting information about the list with reps.
     *
     * @return a copy of the list with reps.
     */
    public int getNoOfReps() {
        return noOfReps;
    }

    /**
     * Method for getting information about the list with weights.
     *
     * @return a copy of the list with weights.
     */
    public double getWeights() {
        return weight;
    }

    /**
     * Method for changing a specific value in the list of reps.
     *
     * @param noOfReps new value for reps
     */
    protected void changeRep(int noOfReps){
        this.noOfReps = noOfReps;
    }

    /**
     * Method for changing a specific value in the list of weights.
     *
     * @param weight new value for weight
     */
    protected void changeWeight(double weight){
        this.weight = weight;
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
     * Method for getting the exerciseId of the exercise
     *
     * @return The exerciseId of the exercise
     */
    public String getExerciseId(){
        return exerciseId;
    }

}

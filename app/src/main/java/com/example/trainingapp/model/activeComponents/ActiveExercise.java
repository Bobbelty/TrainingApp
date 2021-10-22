package com.example.trainingapp.model.activeComponents;

import com.example.trainingapp.model.components.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class for creating an active exercise. The class is identical to the Exercise-class, but with added
 * variables and logic to handle a weight used at each set.
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
    private String exerciseId;

    /**
     * Class constructor. Responsible for converting an exercise to an active exercise.
     * @param exercise The exercise-object to be converted.
     */
    public ActiveExercise(Exercise exercise){
        this.exerciseName = exercise.getName();
        this.exerciseId = UUID.randomUUID().toString();
        this.noOfReps = exercise.getNumberOfReps();
        this.weight = 0;
    }

    /**
     * This method converts the format of reps/sets from int reps x int sets to a list of
     * reps and size of list is the number of sets.
     *
     * @param reps value of each startvalue in list
     * @param sets size of list
     */

    /**
     * Method for creating a list of weights that corresponds to the list of reps.
     * The size of the weightlist must be the same as the size of the replist. Default element value
     * is zero.
     *
     * @param listOfReps Used to know the necessary size of the weightlist.
     */

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
     * @param index position in the list where the value will change at.
     * @param change new value.
     */
    public void changeRep(int noOfReps){
        this.noOfReps = noOfReps;
    }

    /**
     * Method for changing a specific value in the list of weights.
     *
     * @param index position in the list where the value will change at.
     * @param change new value.
     */
    public void changeWeight(double weight){
        this.weight = weight;
    }

    /**
     * Method for adding another set of reps to the list of reps. The list with weights will also
     * get a corresponding weightelement, initially zero.
     *
     * @param amountOfReps amount of reps for the new set.
     */


    /**
     * Method for removing a set from the list of reps. The corresponding weight will be removed
     * from the list with weights.
     *
     * @param index which index to be removed.
     */


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

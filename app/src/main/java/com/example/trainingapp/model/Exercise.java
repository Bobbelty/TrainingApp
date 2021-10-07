package com.example.trainingapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class for creating an exercise. Several exercises makes up a workout
 */
public class Exercise {

    /**
     * Name of the exercise
     */
    String exerciseName;


    /**
     * List of reps for each set. Each element of the list is the nr of reps and the size of the
     * list is the nr of sets. Ex [12, 12, 12] means 3 sets of 12
     */

    List<Integer> sets = new ArrayList<>();


    /**
     * An exercise contains an id to make it possible for PB-recording purposes. For example
     * all Bench Press exercises will have the same id.
     */
    private int exerciseId;

    /**
     * Class constructor setting exerciseName and exerciseId
     *
     * @param exerciseName name of exercise
     * @param exerciseId Id of exercise
     */
    public Exercise(String exerciseName, int exerciseId) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
    }

    /**
     * Returns the list of sets.
     * @return list of sets
     */

    public List<Integer> getReps(){
        return sets;
    }

    /**
     * Method for adding a new set to the exercises' list of sets
     * @param rep Amount of reps that the new set contains
     */

    public void addSet(Integer rep){
        sets.add(rep);
    }

    /**
     * Method for removing a set from the exercises' list of sets
     * @param index The index of the set that you want to remove
     */

    public void removeSet(int index){
        sets.remove(index);

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



}

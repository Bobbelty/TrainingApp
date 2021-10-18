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
     * List of reps. Ex 12 + 12 + 8 -> 3 sets with different amount of repetitions.
     */
    private List<Integer> listOfReps;

    /**
     * This is a list of the weight used in each set. Default value is zero.
     */
    private List<Integer> listOfWeights;

    /**
     * An exercise contains an id to make it possible for PB-recording purposes. For example
     * all Bench Press exercises will have the same id.
     */
    private int exerciseId;

    /**
     * Class constructor. Responsible for converting an exercise to an active exercise.
     * @param exercise The exercise-object to be converted.
     */
    public ActiveExercise(Exercise exercise){
        this.exerciseName = exercise.getName();
        this.exerciseId = exercise.getExerciseId();
        convertRepsSetsToList(exercise.getNumberOfReps(), exercise.getNumberOfSets());
        createListOfWeights(listOfReps);
    }

    /**
     * This method converts the format of reps/sets from int reps x int sets to a list of
     * reps and size of list is the number of sets.
     *
     * @param reps value of each startvalue in list
     * @param sets size of list
     */
    private void convertRepsSetsToList(int reps, int sets){
        for(int i = 0; i < sets; i++){
            listOfReps.add(reps);
        }
    }

    /**
     * Method for creating a list of weights that corresponds to the list of reps.
     * The size of the weightlist must be the same as the size of the replist. Default value
     * is zero.
     *
     * @param listOfReps Used to know the necessary size of the weightlist
     */
    private void createListOfWeights(List<Integer> listOfReps){
        for(int i = 0; i < listOfReps.size(); i++){
            listOfWeights.add(0);
        }
    }

    public List<Integer> getListOfReps() {
        return listOfReps;
    }

    public List<Integer> getListOfWeights() {
        return listOfWeights;
    }

    public void changeRepInList(int index, int change){
        listOfReps.set(index, change);
    }

    public void changeWeightInList(int index, int change){
        listOfWeights.set(index, change);
    }

    public void addSetToList(int amountOfReps){
        listOfReps.add(amountOfReps);
        listOfWeights.add(0);
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
    public int getExerciseId(){
        return exerciseId;
    }




}

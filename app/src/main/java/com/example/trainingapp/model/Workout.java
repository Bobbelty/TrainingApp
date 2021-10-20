package com.example.trainingapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A class for building a workout. A workout contains zero or more exercises. Workouts are a part of a plan.
 *
 * @author ...
 */
public class Workout {

    /**
     * The name of the workout
     */
    private String workoutName;

    /**
     * List containing all the exercises in the workout
     */
    private List<Exercise> exercises = new ArrayList<>();

    /**
     * Class constructor setting workoutName
     *
     * @param workoutName name of workout
     */
    public Workout(String workoutName) {
        this.workoutName = workoutName;
    }


    /**
     * Returns the name of the workout
     *
     * @return Name of the workout
     */
    public String getName() {
        return workoutName;
    }


    /**
     * Returns the list of exercises
     *
     * @return the list of exercises that Workout contains
     */
    public List<Exercise> getExerciseList(){
        return exercises;
    }

    /**
     * Method for adding an exerciseObject to the list of exercises
     *
     * @param exercise object to add to list
     */
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }


    /**
     * Method for removing an exerciseObject from the list of exercises
     *
     * @param exercise object to remove from the list
     */
    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }
}

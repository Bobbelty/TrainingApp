package com.example.trainingapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A class for buidling a workout. A workout contains zero or more exercises. Workouts are a part of a plan.
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
     * @return workouts name
     */
    public String getName() {
        return workoutName;
    }

    /**
     * Method for adding an exerciseobject to the list of exercises
     *
     * @param exercise object to add to list
     */
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public List<Exercise> getExerciseList(){
        return exercises;
    }

    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }
}

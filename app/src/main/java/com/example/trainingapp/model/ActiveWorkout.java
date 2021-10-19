package com.example.trainingapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ActiveWorkout acts closely to the Workout-class with the exception of containing active exercises
 * instead of normal exercises and a timestamp.
 * This class is used when the User in the UI has started a workout and therefore the selected workout
 * is converted into an ActiveWorkout.
 *
 * @author ...
 */
public class ActiveWorkout {

    /**
     * The name of the workout
     */
    private String workoutName;

    /**
     * List containing all the exercises in the workout
     */
    private List<ActiveExercise> exercises = new ArrayList<>();

    /**
     * The time for the active workout, used for history
     */
    private String currentTime;

    /**
     * Class constructor setting workoutName
     *
     * @param workoutName name of workout
     */
    public ActiveWorkout(String workoutName) {
        this.workoutName = workoutName;
        currentTime = "0";
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
     * Method for adding an exerciseObject to the list of exercises
     *
     * @param exercise object to add to list
     */
    public void addExercise(ActiveExercise exercise) {
        exercises.add(exercise);
    }

    /**
     * Returns the list of exercises
     *
     * @return the list of exercises that Workout contains
     */
    public List<ActiveExercise> getExerciseList(){
        return exercises;
    }

    /**
     * Method for removing an exerciseObject from the list of exercises
     *
     * @param exercise object to remove from the list
     */
    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }

    /**
     * Returns the date of the active workout (on session end)
     *
     * @return the date of the active workout
     */
    public String getTime() {
        return currentTime;
    }

    /**
     * Returns the list of exercises
     * @param currentTime
     */
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}

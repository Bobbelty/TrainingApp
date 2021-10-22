package com.example.trainingapp.model.activeComponents;

import com.example.trainingapp.model.components.Exercise;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

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
     * HashMap for storing the active exercises in a active workout
     */

    private HashMap<String, ActiveExercise> activeExerciseMap = new HashMap<>();

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
     * Constructor for defensive copying, used when performing active workouts
     *
     * @param activeWorkout the active workout in use
     */
    public ActiveWorkout(ActiveWorkout activeWorkout){
        this.workoutName = activeWorkout.workoutName;
        this.activeExerciseMap = new HashMap<>(activeWorkout.activeExerciseMap);
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
     * Method for adding an exerciseObject to the map of exercises
     *
     * @param exercise object to add to map
     */
    public void addExercise(ActiveExercise exercise) {
        activeExerciseMap.put(exercise.getExerciseId(), exercise);
    }

    /**
     * Returns the list of exercises
     *
     * @return the list of exercises that Workout contains
     */
    public List<ActiveExercise> getExerciseList(){
        List<ActiveExercise> activeExercises = new ArrayList<>();
        for(String key: activeExerciseMap.keySet()){
            activeExercises.add(activeExerciseMap.get(key));
        }
        return activeExercises;
        }

    /**
     * Method for getting a exercise at the index
     *
     * @param index position in the list where the wanted exercises is
     * @return The exerciseId of the exercise
     */
    //TODO is this ok?
    public ActiveExercise getExercise(int index){
            return getExerciseList().get(index);
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
     * Sets the timestamp when an active workout is ended.
     *
     * @param currentTime is set (YYYY-MM-DD) when the workout ends.
     */
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * Adds a set to the active exercise
     *
     * @param exerciseId the id of the exercise that adds the set
     */
    public void addSetToExercise(String exerciseId){
        activeExerciseMap.get(exerciseId).addSetToList(0);
    }

    /**
     * Updates the active exercise's reps for a specified set
     *
     * @param reps the new amount of reps
     * @param exerciseId the id of the exercise that is updated
     * @param index the position of the set that is updated
     */
    public void updateActiveExerciseRep(int reps, String exerciseId, int index){
        activeExerciseMap.get(exerciseId).updateRep(reps, index);
    }

    /**
     * Removes the active exercise's specified set
     *
     * @param exerciseId the id of the exercise that is updated
     * @param index the position of the set that is removed
     */
    public void removeSetFromExercise(String exerciseId, int index){
        activeExerciseMap.get(exerciseId).removeSetFromList(index);
    }

    /**
     * Updates the weight for a set in the active exercise
     *
     * @param exerciseId the id for the exercise that is updated
     * @param index the position of the set that is being updated
     * @param newWeight the new value for the weight
     */
    public void updateWeightInSet(String exerciseId, int index, int newWeight) {
        activeExerciseMap.get(exerciseId).changeWeightInList(index, newWeight);
    }
}

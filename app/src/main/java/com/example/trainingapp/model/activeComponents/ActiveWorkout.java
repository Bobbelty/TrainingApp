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
     * List containing all the exercises in the workout
     */
    private List<ActiveExercise> exercises = new ArrayList<>();

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

    public ActiveWorkout(ActiveWorkout activeWorkout){

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
        List<ActiveExercise> activeExercises = new ArrayList<>();
        for(String key: activeExerciseMap.keySet()){
            exercises.add(activeExerciseMap.get(key));
        }
        return activeExercises;
        }

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

    public void addSetToExercise(String exerciseId){
        activeExerciseMap.get(exerciseId).addSetToList(0);
    }

    public void updateActiveExerciseRep(int reps, String exerciseId, int index){
        activeExerciseMap.get(exerciseId).updateRep(reps, index);
    }

    public void removeSetFromExercise(String exerciseId, int index){
        activeExerciseMap.get(exerciseId).removeSetFromList(index);
    }

    public void updateWeightInSet(String exerciseId, int index, int change) {
        activeExerciseMap.get(exerciseId).changeWeightInList(index, change);
    }

    public void updateActiveExerciseRep(String exerciseId, int index) {

    }
}

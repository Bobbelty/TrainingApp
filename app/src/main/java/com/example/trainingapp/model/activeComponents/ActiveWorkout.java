package com.example.trainingapp.model.activeComponents;

import com.example.trainingapp.model.components.Exercise;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    private LinkedHashMap<String, ActiveExercise> activeExerciseMap = new LinkedHashMap<>();

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
        this.activeExerciseMap = new LinkedHashMap<>(activeWorkout.activeExerciseMap);
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
     * Method for updating a rep in an active exercise
     *
     * @param reps new amount of reps
     * @param exerciseId the Id for the exercise
     */
    public void updateActiveExerciseRep(int reps, String exerciseId){
        activeExerciseMap.get(exerciseId).changeRep(reps);
    }

    /**
     * Method for updating the weight in a set
     *
     * @param exerciseId the Id for the exercise
     * @param weight new value for weight
     */
    public void updateWeightInSet(String exerciseId, double weight) {
        activeExerciseMap.get(exerciseId).changeWeight(weight);
    }
}

package com.example.trainingapp.model.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

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
   // private List<Exercise> exercises = new ArrayList<>();
    private LinkedHashMap<String, Exercise> exerciseMap = new LinkedHashMap<>();

    private final String workoutId;

    /**
     * Class constructor setting workoutName
     *
     */
/*
    public Workout() {
        this.workoutName = "New Workout";

    public Workout(String workoutName) {
        this.workoutName = workoutName;
        this.workoutId = UUID.randomUUID().toString();
    }
    */
 

    public Workout() {
        this.workoutName ="New Workout";
        this.workoutId = UUID.randomUUID().toString();
    }

    public Workout(Workout workout){
        this.workoutName = workout.workoutName;
        this.workoutId = workout.workoutId;
        this.exerciseMap = new LinkedHashMap<>(workout.exerciseMap);
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
    List<Exercise> exercises = new ArrayList<>();
    for(String key: exerciseMap.keySet()){
        exercises.add(exerciseMap.get(key));
    }
    return exercises;
    }

    //TODO is this ok?
    public Exercise getExercise(int index){
        return getExerciseList().get(index);
    }

    /**
     * Method for adding an exerciseObject to the list of exercises
     *
     * @param exercise object to add to list
     */
    public void addExercise(Exercise exercise) {
        exerciseMap.put(exercise.getId(), exercise);
    }

    /**
     * Method for removing an exerciseObject from the list of exercises
     *
     * @param exercise object to remove from the list
     */
    public void removeExercise(String exerciseId) {
        exerciseMap.remove(exerciseId);
    }

    public void updateExerciseName(String name, String exerciseId){
        exerciseMap.get(exerciseId).setName(name);
    }

    public void setName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getId() {
        return workoutId;
    }

    public void updateExerciseRep(String exerciseId, int reps) {
        exerciseMap.get(exerciseId).setNumberOfReps(reps);
    }

    public void updateExerciseSets(String exerciseId, int sets){
        exerciseMap.get(exerciseId).setNumberOfSets(sets);
    }
}

package com.example.trainingapp.model.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
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
     * LinkedHashMap containing all the exercises in the workout
     */
    private LinkedHashMap<String, Exercise> exerciseMap = new LinkedHashMap<>();

    /**
     * The id for the workout
     */
    private final String workoutId;

    /**
     * Class constructor setting a default workoutName and generated workoutId
     */
    public Workout() {
        this.workoutName ="New Workout";
        this.workoutId = UUID.randomUUID().toString();
    }

    /**
     * Class constructor setting a specified workoutName and generated workoutId
     */
    public Workout(String workoutName) {
        this.workoutName = workoutName;
        this.workoutId = UUID.randomUUID().toString();
    }

    /**
     * Class constructor for defensive copying of a workout
     */
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
     * Returns a list of exercises, copying the LinkedHashMap to a list
     *
     * @return a list of exercises that Workout contains
     */
    public List<Exercise> getExerciseList(){
    List<Exercise> exercises = new ArrayList<>();
    for(String key: exerciseMap.keySet()){
        exercises.add(exerciseMap.get(key));
    }
    return exercises;
    }

    /**
     * Method for getting an exercise from the specified index in the list
     *
     * @param index the position of the exercise in the list
     *
     * @return the exercise object
     */
    public Exercise getExerciseByIndex(int index){
        return getExerciseList().get(index);
    }

    /**
     * Method for adding an exerciseObject to the map of exercises
     *
     * @param exercise object to add to list
     */
    public void addExercise(Exercise exercise) {
        exerciseMap.put(exercise.getId(), exercise);
    }

    /**
     * Method for removing an exercise object from the map of exercises
     *
     * @param exerciseId the id of the exercise
     */
    public void removeExercise(String exerciseId) {
        exerciseMap.remove(exerciseId);
    }



    /**
     * Method for setting a name for a workout
     *
     * @param workoutName the new name for the workout
     */
    public void setName(String workoutName) {
        this.workoutName = workoutName;
    }

    /**
     * Method for getting the Id for the workout
     *
     * @return the Id of the workout
     */
    public String getId() {
        return workoutId;
    }

    private Exercise getExerciseFromMap(String exerciseId) throws NullPointerException{
        return Objects.requireNonNull(exerciseMap.get(exerciseId), "No exercise with this Id exists");
    }

    /**
     * Method for updating the exercise name
     *
     * @param name the new name of the exercise
     * @param exerciseId the Id of the exercise
     */
    public void updateExerciseName(String name, String exerciseId) throws NullPointerException {
        getExerciseFromMap(exerciseId).setName(name);
    }

    /**
     * Method for updating the number of reps in a set in the exercise
     *
     * @param exerciseId the Id of the exercise
     * @param reps the new number of reps
     */
    public void updateExerciseRep(String exerciseId, int reps) throws NullPointerException {
        getExerciseFromMap(exerciseId).setNumberOfReps(reps);
    }

    /**
     * Method for updating the number of sets in the exercise
     *
     * @param exerciseId the Id of the exercise
     * @param sets the new number of sets
     */
    public void updateExerciseSets(String exerciseId, int sets) throws NullPointerException{
        getExerciseFromMap(exerciseId).setNumberOfSets(sets);
    }
}

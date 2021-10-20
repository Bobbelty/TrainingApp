package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.IDatabase;
import com.example.trainingapp.mockDataBase.MockDataBase;
import com.example.trainingapp.model.ActiveWorkoutSession;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The User-class act as a datahandler that connects all of the model with the modelfacade and the
 * database.
 */
public class User {

    /**
     * ActiveWorkoutSession-object to access logic for ActiveWorkout and ActiveExercise.
     */
    private final ActiveWorkoutSession activeWorkoutSession = new ActiveWorkoutSession();

    /**
     * ExerciseIdHandler-object for creating new exerciseId:s
     */
    private final ExerciseIdHandler exerciseIdHandler = new ExerciseIdHandler();

    /**
     * PlanBuilder-object for access to the modelcomponents (Exercise, Workout, Plan)
     */
    private final PlanBuilder planBuilder = new PlanBuilder();

    /**
     * User uses a MockDatabase to store plans, workouts and exercises
     * during runtime
     */
    private final IDatabase mockDataBase = new MockDataBase();

    /**
     * nextId used for generating unique id:S
     */
    private static AtomicInteger nextId = new AtomicInteger();

    /**
     * Method for returning a list of the stored plans from the database
     *
     * @return list of plans from database
     */
    public List<Plan> getSavedPlans(){
        return mockDataBase.getPlanList();
    }

    /**
     * Method for removing the selected plan (first in list) from the database.
     */
    public void removePlan(Plan selectedPlan) {
        getSavedPlans().remove(selectedPlan);
    }
     * Method for receiving the list of completed workouts from the database.
     *
     * @return the list of completed workouts.
     */
    public List<ActiveWorkout> getCompletedWorkouts() {return mockDataBase.getCompletedWorkouts();}

    /**
     * Returns a new Plan-object
     *
     * @param planName the name of the plan
     */
    public void createNewPlan(String planName){
        mockDataBase.addPlan(planBuilder.createNewPlan(planName));
    }

    /**
     * Method for adding a workout to a plan
     *
     * @param plan the reference to the plan object
     * @param name the name of the Workout-object that gets added to the Plan
     */
    public void addWorkoutToPlan(Plan plan, String name){
        planBuilder.addWorkoutToPlan(plan, name);
    }

    /**
     * Method for removing a workout from a plan
     *
     * @param plan the reference to the plan object
     * @param workout the reference to the workout object
     */
    public void removeWorkoutFromPlan(Plan plan, Workout workout) {
        planBuilder.removeWorkoutFromPlan(plan, workout);
    }

    /**
     * Method for adding an exercise to a workout
     *
     * @param workout the reference to the workout object
     * @param exerciseName the name of the exercise
     */
    public void addExerciseToWorkout(Workout workout, String exerciseName) {
        try{
            int exerciseId = mockDataBase.getExerciseIdFromMap(exerciseName);
            planBuilder.addExerciseToWorkout(workout, exerciseName, exerciseId);
        } catch (ExerciseIdNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for removing an exercise from a workout
     *
     * @param workout the reference to the Workout-object
     * @param exercise the Exercise-object to be removed
     */
    public void removeExerciseFromWorkout(Workout workout, Exercise exercise){
        planBuilder.removeExerciseFromWorkout(workout, exercise);
    }

    /**
     * Method for creating a new exercise(not in a workout, just for purposes of storing
     * it in database). Also connects an exerciseId to the exercise.
     *
     * @param exerciseIdName The exercise name that the exerciseId corresponds to
     */
    public void createAndSaveNewExerciseToDatabase(String exerciseIdName){
        int id = nextId.getAndIncrement();
        mockDataBase.addExerciseIdToMap(exerciseIdName, id);
    }

    public void createAndSaveActiveWorkoutToDatabase(Workout workout){

    }

}
